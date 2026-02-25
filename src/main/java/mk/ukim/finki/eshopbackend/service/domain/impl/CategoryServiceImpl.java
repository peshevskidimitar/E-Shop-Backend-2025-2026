package mk.ukim.finki.eshopbackend.service.domain.impl;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.domain.Category;
import mk.ukim.finki.eshopbackend.repository.CategoryRepository;
import mk.ukim.finki.eshopbackend.service.domain.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> update(Long id, Category category) {
        return categoryRepository
            .findById(id)
            .map((existingCategory) -> {
                existingCategory.setName(category.getName());
                existingCategory.setDescription(category.getDescription());
                return categoryRepository.save(existingCategory);
            });
    }

    @Override
    public Optional<Category> deleteById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        category.ifPresent(categoryRepository::delete);
        return category;
    }
}
