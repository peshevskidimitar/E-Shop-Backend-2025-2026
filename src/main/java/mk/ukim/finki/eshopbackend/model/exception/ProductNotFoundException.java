package mk.ukim.finki.eshopbackend.model.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("A product with id %d does not exist.".formatted(id));
    }
}
