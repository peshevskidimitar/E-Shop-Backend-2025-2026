package mk.ukim.finki.eshopbackend.service.application;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.dto.DisplayProductCatalogViewDto;

public interface ProductCatalogViewApplicationService {
    List<DisplayProductCatalogViewDto> findAll();
}
