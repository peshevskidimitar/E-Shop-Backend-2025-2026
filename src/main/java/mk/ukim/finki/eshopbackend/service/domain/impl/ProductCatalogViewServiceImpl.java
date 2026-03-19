package mk.ukim.finki.eshopbackend.service.domain.impl;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.views.ProductCatalogView;
import mk.ukim.finki.eshopbackend.repository.ProductCatalogViewRepository;
import mk.ukim.finki.eshopbackend.service.domain.ProductCatalogViewService;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogViewServiceImpl implements ProductCatalogViewService {
    private final ProductCatalogViewRepository productCatalogViewRepository;

    public ProductCatalogViewServiceImpl(ProductCatalogViewRepository productCatalogViewRepository) {
        this.productCatalogViewRepository = productCatalogViewRepository;
    }

    @Override
    public List<ProductCatalogView> findAll() {
        return productCatalogViewRepository.findAll();
    }
}
