package mk.ukim.finki.eshopbackend.service.domain;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.domain.Category;

public interface CategoryService {
    Optional<Category> findById(Long id);

    List<Category> findAll();

    Category create(Category category);

    Optional<Category> update(Long id, Category category);

    Optional<Category> deleteById(Long id);
}
