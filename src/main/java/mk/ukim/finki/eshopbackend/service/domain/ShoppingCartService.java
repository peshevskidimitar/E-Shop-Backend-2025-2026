package mk.ukim.finki.eshopbackend.service.domain;

import mk.ukim.finki.eshopbackend.model.domain.ShoppingCart;
import mk.ukim.finki.eshopbackend.model.domain.User;

public interface ShoppingCartService {
    void checkout(Long cartId);

    ShoppingCart addToShoppingCart(User user, Long productId, Integer quantity);

    ShoppingCart removeFromShoppingCart(User user, Long productId);
}