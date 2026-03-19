package mk.ukim.finki.eshopbackend.repository;

import mk.ukim.finki.eshopbackend.model.views.ProductCatalogView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalogViewRepository extends JpaRepository<ProductCatalogView, Long> {
    @Modifying
    @Query(value = "call refresh_product_catalog_view()", nativeQuery = true)
    void refresh();
}
