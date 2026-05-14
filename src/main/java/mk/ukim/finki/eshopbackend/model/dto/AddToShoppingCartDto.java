package mk.ukim.finki.eshopbackend.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AddToShoppingCartDto(
    @NotNull
    Long productId,
    @NotNull
    @Positive
    Integer quantity
) {
}