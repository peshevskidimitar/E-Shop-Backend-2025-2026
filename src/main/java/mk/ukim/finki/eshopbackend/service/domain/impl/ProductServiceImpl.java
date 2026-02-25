package mk.ukim.finki.eshopbackend.service.domain.impl;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.domain.Product;
import mk.ukim.finki.eshopbackend.repository.ProductRepository;
import mk.ukim.finki.eshopbackend.service.domain.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return productRepository
            .findById(id)
            .map((existingProduct) -> {
                existingProduct.setName(product.getName());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setQuantity(product.getQuantity());
                existingProduct.setCategory(product.getCategory());
                return productRepository.save(existingProduct);
            });
    }

    @Override
    public Optional<Product> deleteById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(productRepository::delete);
        return product;
    }
}
