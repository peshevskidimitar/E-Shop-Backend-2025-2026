package mk.ukim.finki.eshopbackend.jobs;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.eshopbackend.repository.ProductCatalogViewRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MaterializedViewRefreshScheduler {
    private final ProductCatalogViewRepository productCatalogViewRepository;

    public MaterializedViewRefreshScheduler(ProductCatalogViewRepository productCatalogViewRepository) {
        this.productCatalogViewRepository = productCatalogViewRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void refreshProductCatalogView() {
        log.info("Refreshing PRODUCT_CATALOG_VIEW...");
        productCatalogViewRepository.refresh();
        log.info("PRODUCT_CATALOG_VIEW successfully refreshed.");
    }
}
