package mk.ukim.finki.eshopbackend.service.domain;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.domain.Product;

public interface ProductService {
    Optional<Product> findById(Long id);

    List<Product> findAll();

    Product create(Product product);

    Optional<Product> update(Long id, Product product);

    Optional<Product> deleteById(Long id);
}
