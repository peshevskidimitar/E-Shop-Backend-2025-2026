package mk.ukim.finki.eshopbackend.model.dto;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.domain.ShoppingCart;

public record DisplayShoppingCartDto(
    Long id,
    List<DisplayCartItemDto> cartItems
) {
    public static DisplayShoppingCartDto from(ShoppingCart shoppingCart) {
        return new DisplayShoppingCartDto(
            shoppingCart.getId(),
            DisplayCartItemDto.from(shoppingCart.getCartItems())
        );
    }
}