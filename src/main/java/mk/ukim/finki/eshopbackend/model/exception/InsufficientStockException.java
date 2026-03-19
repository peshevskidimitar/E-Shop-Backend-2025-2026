package mk.ukim.finki.eshopbackend.model.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String productName) {
        super("Not enough stock for %s.".formatted(productName));
    }
}
