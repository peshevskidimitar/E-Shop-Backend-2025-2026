package mk.ukim.finki.eshopbackend.repository;

import mk.ukim.finki.eshopbackend.model.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
