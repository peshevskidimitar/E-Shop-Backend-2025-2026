package mk.ukim.finki.eshopbackend.web.controller;

import jakarta.validation.Valid;
import java.util.List;
import mk.ukim.finki.eshopbackend.model.dto.CreateProductDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayProductDto;
import mk.ukim.finki.eshopbackend.service.application.ProductApplicationService;
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
@RequestMapping("/api/products")
public class ProductController {
    private final ProductApplicationService productApplicationService;

    public ProductController(ProductApplicationService productApplicationService) {
        this.productApplicationService = productApplicationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayProductDto> findById(@PathVariable Long id) {
        return productApplicationService
            .findById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayProductDto>> findAll() {
        return ResponseEntity.ok(productApplicationService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayProductDto> create(@RequestBody @Valid CreateProductDto createProductDto) {
        return ResponseEntity.ok(productApplicationService.create(createProductDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayProductDto> update(
        @PathVariable Long id,
        @RequestBody CreateProductDto createProductDto
    ) {
        return productApplicationService
            .update(id, createProductDto)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayProductDto> deleteById(@PathVariable Long id) {
        return productApplicationService
            .deleteById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
