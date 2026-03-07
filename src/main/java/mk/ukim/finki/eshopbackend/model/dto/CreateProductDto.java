package mk.ukim.finki.eshopbackend.model.dto;

import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import mk.ukim.finki.eshopbackend.model.domain.Category;
import mk.ukim.finki.eshopbackend.model.domain.Product;

public record CreateProductDto(
    String name,
    String description,
    @Positive
    BigDecimal price,
    @Positive
    Integer quantity,
    Long categoryId
) {
    public Product toProduct(Category category) {
        return new Product(name, description, price, quantity, category);
    }
}
