package mk.ukim.finki.eshopbackend.model.dto;

import java.math.BigDecimal;
import java.util.List;
import mk.ukim.finki.eshopbackend.model.views.ProductCatalogView;

public record DisplayProductCatalogViewDto(
    String productName,
    String productDescription,
    BigDecimal productPrice,
    Integer productQuantity,
    String categoryName,
    Integer timesAddedToCart,
    Integer totalQuantityInCarts
) {
    public static DisplayProductCatalogViewDto from(ProductCatalogView productCatalogView) {
        return new DisplayProductCatalogViewDto(
            productCatalogView.getProductName(),
            productCatalogView.getProductDescription(),
            productCatalogView.getProductPrice(),
            productCatalogView.getProductQuantity(),
            productCatalogView.getCategoryName(),
            productCatalogView.getTimesAddedToCart(),
            productCatalogView.getTotalQuantityInCarts()
        );
    }

    public static List<DisplayProductCatalogViewDto> from(List<ProductCatalogView> productCatalogViews) {
        return productCatalogViews
            .stream()
            .map(DisplayProductCatalogViewDto::from)
            .toList();
    }
}
