package mk.ukim.finki.eshopbackend.repository;

import mk.ukim.finki.eshopbackend.model.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
