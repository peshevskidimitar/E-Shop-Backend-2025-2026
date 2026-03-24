package mk.ukim.finki.eshopbackend.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import mk.ukim.finki.eshopbackend.model.domain.CartItem;
import mk.ukim.finki.eshopbackend.model.domain.Category;
import mk.ukim.finki.eshopbackend.model.domain.Product;
import mk.ukim.finki.eshopbackend.model.domain.ShoppingCart;
import mk.ukim.finki.eshopbackend.model.domain.User;
import mk.ukim.finki.eshopbackend.repository.CartItemRepository;
import mk.ukim.finki.eshopbackend.repository.CategoryRepository;
import mk.ukim.finki.eshopbackend.repository.ProductRepository;
import mk.ukim.finki.eshopbackend.repository.ShoppingCartRepository;
import mk.ukim.finki.eshopbackend.repository.UserRepository;
import mk.ukim.finki.eshopbackend.service.domain.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Testcontainers
@Transactional
class CheckoutServiceIntegrationTest {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16")
        .withDatabaseName("eshop_test")
        .withUsername("test")
        .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShoppingCartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void testCheckout() {
        User user = userRepository.save(new User("John", "Doe", "john@test.com"));
        Category category = categoryRepository.save(new Category("Electronics", ""));
        Product product = productRepository.save(
            new Product("iPhone 15", "", BigDecimal.valueOf(999), 10, category));
        ShoppingCart cart = cartRepository.save(new ShoppingCart(user));

        cartItemRepository.save(new CartItem(cart, product, 3));

        entityManager.flush();
        entityManager.clear();

        shoppingCartService.checkout(cart.getId());

        entityManager.flush();
        entityManager.clear();

        Product updated = productRepository.findById(product.getId()).orElseThrow();
        assertThat(updated.getQuantity()).isEqualTo(7);
    }
}