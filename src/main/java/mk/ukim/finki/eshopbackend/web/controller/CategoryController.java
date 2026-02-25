package mk.ukim.finki.eshopbackend.web.controller;

import jakarta.validation.Valid;
import java.util.List;
import mk.ukim.finki.eshopbackend.model.dto.CreateCategoryDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayCategoryDto;
import mk.ukim.finki.eshopbackend.service.application.CategoryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryApplicationService categoryApplicationService;

    public CategoryController(CategoryApplicationService categoryApplicationService) {
        this.categoryApplicationService = categoryApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCategoryDto> findById(@PathVariable Long id) {
        return categoryApplicationService
            .findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayCategoryDto>> findAll() {
        return ResponseEntity.ok(categoryApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayCategoryDto> create(@RequestBody @Valid CreateCategoryDto createCategoryDto) {
        return ResponseEntity.ok(categoryApplicationService.create(createCategoryDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayCategoryDto> update(
        @PathVariable Long id,
        @RequestBody CreateCategoryDto createCategoryDto
    ) {
        return categoryApplicationService
            .update(id, createCategoryDto)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayCategoryDto> deleteById(@PathVariable Long id) {
        return categoryApplicationService
            .deleteById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
