package mk.ukim.finki.eshopbackend.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "shopping_carts")
@NamedEntityGraph(
    name = "shopping-cart-entity-graph",
    attributeNodes = {
        @NamedAttributeNode(value = "cartItems", subgraph = "cart-item-subgraph"),
    },
    subgraphs = {
        @NamedSubgraph(
            name = "cart-item-subgraph",
            attributeNodes = {
                @NamedAttributeNode("product")
            }
        )
    }
)
public class ShoppingCart extends BaseAuditableEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @OneToMany(mappedBy = "shoppingCart")
    private List<CartItem> cartItems = new ArrayList<>();

    public ShoppingCart(User user) {
        this.user = user;
    }
}
