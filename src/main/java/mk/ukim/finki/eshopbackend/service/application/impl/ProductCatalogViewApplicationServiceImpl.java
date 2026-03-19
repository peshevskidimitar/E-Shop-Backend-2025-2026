package mk.ukim.finki.eshopbackend.service.application.impl;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.dto.DisplayProductCatalogViewDto;
import mk.ukim.finki.eshopbackend.service.application.ProductCatalogViewApplicationService;
import mk.ukim.finki.eshopbackend.service.domain.ProductCatalogViewService;
import org.springframework.stereotype.Service;

@Service
public class ProductCatalogViewApplicationServiceImpl implements ProductCatalogViewApplicationService {
    private final ProductCatalogViewService productCatalogViewService;

    public ProductCatalogViewApplicationServiceImpl(ProductCatalogViewService productCatalogViewService) {
        this.productCatalogViewService = productCatalogViewService;
    }

    @Override
    public List<DisplayProductCatalogViewDto> findAll() {
        return DisplayProductCatalogViewDto.from(productCatalogViewService.findAll());
    }
}
