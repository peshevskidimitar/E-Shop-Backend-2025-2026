package mk.ukim.finki.eshopbackend.service;

import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mk.ukim.finki.eshopbackend.model.exception.InsufficientStockException;
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
import org.junit.jupiter.api.BeforeEach;
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
class CheckoutConcurrencyTest {
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

    @Autowired private ShoppingCartService shoppingCartService;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private ShoppingCartRepository cartRepository;
    @Autowired private CartItemRepository cartItemRepository;
    @Autowired private EntityManager entityManager;

    private Category category;
    private Product product;
    private ShoppingCart cart1;
    private ShoppingCart cart2;

    @BeforeEach
    void setUp() {
        category = categoryRepository.save(new Category("Electronics", ""));
        product = productRepository.save(
            new Product("Last iPhone", "", BigDecimal.valueOf(999), 1, category));

        User user1 = userRepository.save(new User("John", "Doe", "john@test.com"));
        User user2 = userRepository.save(new User("Jane", "Doe", "jane@test.com"));

        cart1 = cartRepository.save(new ShoppingCart(user1));
        cart2 = cartRepository.save(new ShoppingCart(user2));

        cartItemRepository.save(new CartItem(cart1, product, 1));
        cartItemRepository.save(new CartItem(cart2, product, 1));

        cart1 = cartRepository.findById(cart1.getId()).orElseThrow();
        cart2 = cartRepository.findById(cart2.getId()).orElseThrow();
    }

    @Test
    void testConcurrentCheckout() throws InterruptedException {
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger failCount = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(2);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            try {
                shoppingCartService.checkout(cart1.getId());
                successCount.incrementAndGet();
            } catch (InsufficientStockException e) {
                failCount.incrementAndGet();
            } finally {
                latch.countDown();
            }
        });

        executor.submit(() -> {
            try {
                shoppingCartService.checkout(cart2.getId());
                successCount.incrementAndGet();
            } catch (InsufficientStockException e) {
                failCount.incrementAndGet();
            } finally {
                latch.countDown();
            }
        });

        latch.await(10, TimeUnit.SECONDS);
        executor.shutdown();

        assertThat(successCount.get()).isEqualTo(1);
        assertThat(failCount.get()).isEqualTo(1);

        Product finalProduct = productRepository.findById(product.getId()).orElseThrow();
        assertThat(finalProduct.getQuantity()).isEqualTo(0);
    }
}