package mk.ukim.finki.eshopbackend.service.application.impl;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.dto.CreateCategoryDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayCategoryDto;
import mk.ukim.finki.eshopbackend.service.application.CategoryApplicationService;
import mk.ukim.finki.eshopbackend.service.domain.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryApplicationServiceImpl implements CategoryApplicationService {
    private final CategoryService categoryService;

    public CategoryApplicationServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Optional<DisplayCategoryDto> findById(Long id) {
        return categoryService
            .findById(id)
            .map(DisplayCategoryDto::from);
    }

    @Override
    public List<DisplayCategoryDto> findAll() {
        return DisplayCategoryDto.from(categoryService.findAll());
    }

    @Override
    public DisplayCategoryDto create(CreateCategoryDto createCategoryDto) {
        return DisplayCategoryDto.from(categoryService.create(createCategoryDto.toCategory()));
    }

    @Override
    public Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto createCategoryDto) {
        return categoryService
            .update(id, createCategoryDto.toCategory())
            .map(DisplayCategoryDto::from);
    }

    @Override
    public Optional<DisplayCategoryDto> deleteById(Long id) {
        return categoryService
            .deleteById(id)
            .map(DisplayCategoryDto::from);
    }
}
