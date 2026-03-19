package mk.ukim.finki.eshopbackend.service.domain.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.eshopbackend.events.CartCheckedOutEvent;
import mk.ukim.finki.eshopbackend.model.domain.CartItem;
import mk.ukim.finki.eshopbackend.model.domain.Product;
import mk.ukim.finki.eshopbackend.model.domain.ShoppingCart;
import mk.ukim.finki.eshopbackend.model.exception.InsufficientStockException;
import mk.ukim.finki.eshopbackend.model.exception.ProductNotFoundException;
import mk.ukim.finki.eshopbackend.model.exception.ShoppingCartNotFoundException;
import mk.ukim.finki.eshopbackend.repository.ProductRepository;
import mk.ukim.finki.eshopbackend.repository.ShoppingCartRepository;
import mk.ukim.finki.eshopbackend.service.domain.ShoppingCartService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ShoppingCartServiceImpl(
        ShoppingCartRepository shoppingCartRepository,
        ProductRepository productRepository,
        ApplicationEventPublisher applicationEventPublisher
    ) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    @Transactional
    public void checkout(Long cartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
            .orElseThrow(() -> new ShoppingCartNotFoundException(cartId));

        for (CartItem item : shoppingCart.getCartItems()) {
            Product product = productRepository.findWithLockById(item.getProduct().getId())
                .orElseThrow(() -> new ProductNotFoundException(item.getProduct().getId()));

            if (product.getQuantity() < item.getQuantity()) {
                throw new InsufficientStockException(product.getName());
            }

            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepository.save(product);
        }

        applicationEventPublisher.publishEvent(
            new CartCheckedOutEvent(shoppingCart, shoppingCart.getUser().getEmail())
        );
    }
}
