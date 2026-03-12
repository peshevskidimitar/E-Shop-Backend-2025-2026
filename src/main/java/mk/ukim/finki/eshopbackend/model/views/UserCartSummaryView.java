package mk.ukim.finki.eshopbackend.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@Table(name = "user_cart_summary_view")
public class UserCartSummaryView {
    @Id
    private Long id;

    private String fullName;

    private String email;

    private Integer totalItems;

    private Integer totalQuantity;

    private BigDecimal totalPrice;
}
