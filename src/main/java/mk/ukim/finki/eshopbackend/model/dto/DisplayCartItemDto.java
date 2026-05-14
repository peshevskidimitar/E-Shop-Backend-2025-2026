package mk.ukim.finki.eshopbackend.model.dto;

import java.math.BigDecimal;
import java.util.List;
import mk.ukim.finki.eshopbackend.model.domain.CartItem;

public record DisplayCartItemDto(
    Long productId,
    String productName,
    BigDecimal price,
    Integer quantity
) {
    public static DisplayCartItemDto from(CartItem cartItem) {
        return new DisplayCartItemDto(
            cartItem.getProduct().getId(),
            cartItem.getProduct().getName(),
            cartItem.getProduct().getPrice(),
            cartItem.getQuantity()
        );
    }

    public static List<DisplayCartItemDto> from(List<CartItem> cartItems) {
        return cartItems
            .stream()
            .map(DisplayCartItemDto::from)
            .toList();
    }
}