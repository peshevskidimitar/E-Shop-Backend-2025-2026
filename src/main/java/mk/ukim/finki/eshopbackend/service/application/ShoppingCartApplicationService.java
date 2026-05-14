package mk.ukim.finki.eshopbackend.service.application;

import mk.ukim.finki.eshopbackend.model.domain.User;
import mk.ukim.finki.eshopbackend.model.dto.AddToShoppingCartDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayShoppingCartDto;

public interface ShoppingCartApplicationService {
    DisplayShoppingCartDto findByUser(User user);

    DisplayShoppingCartDto addToShoppingCart(User user, AddToShoppingCartDto addToShoppingCartDto);

    DisplayShoppingCartDto removeFromShoppingCart(User user, Long productId);

    void checkout(User user);
}