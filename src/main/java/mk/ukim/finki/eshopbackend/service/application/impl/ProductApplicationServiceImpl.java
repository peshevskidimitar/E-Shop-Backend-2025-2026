package mk.ukim.finki.eshopbackend.service.application.impl;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.domain.Category;
import mk.ukim.finki.eshopbackend.model.dto.CreateProductDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayProductDto;
import mk.ukim.finki.eshopbackend.model.exception.CategoryNotFoundException;
import mk.ukim.finki.eshopbackend.service.application.ProductApplicationService;
import mk.ukim.finki.eshopbackend.service.domain.CategoryService;
import mk.ukim.finki.eshopbackend.service.domain.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {
    private final CategoryService categoryService;
    private final ProductService productService;

    public ProductApplicationServiceImpl(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public Optional<DisplayProductDto> findById(Long id) {
        return productService
            .findById(id)
            .map(DisplayProductDto::from);
    }

    @Override
    public List<DisplayProductDto> findAll() {
        return DisplayProductDto.from(productService.findAll());
    }

    @Override
    public DisplayProductDto create(CreateProductDto createProductDto) {
        Category category = categoryService
            .findById(createProductDto.categoryId())
            .orElseThrow(() -> new CategoryNotFoundException(createProductDto.categoryId()));
        return DisplayProductDto.from(productService.create(createProductDto.toProduct(category)));
    }

    @Override
    public Optional<DisplayProductDto> update(Long id, CreateProductDto createProductDto) {
        Category category = categoryService
            .findById(createProductDto.categoryId())
            .orElseThrow(() -> new CategoryNotFoundException(createProductDto.categoryId()));
        return productService
            .update(id, createProductDto.toProduct(category))
            .map(DisplayProductDto::from);
    }

    @Override
    public Optional<DisplayProductDto> deleteById(Long id) {
        return productService
            .deleteById(id)
            .map(DisplayProductDto::from);
    }
}
