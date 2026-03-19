package mk.ukim.finki.eshopbackend.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@Table(name = "product_catalog_view")
public class ProductCatalogView {
    @Id
    private Long id;

    private String productName;

    private String productDescription;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private Long categoryId;

    private String categoryName;

    private Integer timesAddedToCart;

    private Integer totalQuantityInCarts;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
