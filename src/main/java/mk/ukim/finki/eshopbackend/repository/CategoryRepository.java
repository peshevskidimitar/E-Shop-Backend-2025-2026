package mk.ukim.finki.eshopbackend.repository;

import mk.ukim.finki.eshopbackend.model.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
