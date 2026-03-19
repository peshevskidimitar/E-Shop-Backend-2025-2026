package mk.ukim.finki.eshopbackend.service.domain;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.views.ProductCatalogView;

public interface ProductCatalogViewService {
    List<ProductCatalogView> findAll();
}
