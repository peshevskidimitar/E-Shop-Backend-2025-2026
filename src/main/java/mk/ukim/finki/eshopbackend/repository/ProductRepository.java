package mk.ukim.finki.eshopbackend.repository;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Product> findWithLockById(Long id);

    Page<Product> findAll(Pageable pageable);
}
