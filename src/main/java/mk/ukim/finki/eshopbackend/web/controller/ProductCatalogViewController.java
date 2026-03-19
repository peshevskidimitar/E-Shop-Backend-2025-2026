package mk.ukim.finki.eshopbackend.web.controller;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.dto.DisplayProductCatalogViewDto;
import mk.ukim.finki.eshopbackend.service.application.ProductCatalogViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-catalog")
public class ProductCatalogViewController {
    private final ProductCatalogViewApplicationService productCatalogViewApplicationService;

    public ProductCatalogViewController(ProductCatalogViewApplicationService productCatalogViewApplicationService) {
        this.productCatalogViewApplicationService = productCatalogViewApplicationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DisplayProductCatalogViewDto>> findAll() {
        return ResponseEntity.ok(productCatalogViewApplicationService.findAll());
    }
}
