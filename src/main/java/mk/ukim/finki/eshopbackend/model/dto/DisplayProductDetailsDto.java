package mk.ukim.finki.eshopbackend.model.dto;

import java.math.BigDecimal;
import mk.ukim.finki.eshopbackend.model.domain.Product;

public record DisplayProductDetailsDto(
    Long id,
    String name,
    String description,
    BigDecimal price,
    Integer quantity,
    DisplayCategoryDto category
) {
    public static DisplayProductDetailsDto from(Product product) {
        return new DisplayProductDetailsDto(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getQuantity(),
            DisplayCategoryDto.from(product.getCategory())
        );
    }
}