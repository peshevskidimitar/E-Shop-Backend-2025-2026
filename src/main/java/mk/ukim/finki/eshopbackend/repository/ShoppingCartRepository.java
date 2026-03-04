package mk.ukim.finki.eshopbackend.repository;

import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.domain.ShoppingCart;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserId(Long userId);

    @EntityGraph(value = "shopping-cart-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<ShoppingCart> findWithCartItemsByUserId(Long userId);
}
