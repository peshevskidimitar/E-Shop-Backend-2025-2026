package mk.ukim.finki.eshopbackend.model.dto;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.domain.Category;

public record DisplayCategoryDto(
    Long id,
    String name,
    String description
) {
    public static DisplayCategoryDto from(Category category) {
        return new DisplayCategoryDto(
            category.getId(),
            category.getName(),
            category.getDescription()
        );
    }

    public static List<DisplayCategoryDto> from(List<Category> categories) {
        return categories
            .stream()
            .map(DisplayCategoryDto::from)
            .toList();
    }
}
