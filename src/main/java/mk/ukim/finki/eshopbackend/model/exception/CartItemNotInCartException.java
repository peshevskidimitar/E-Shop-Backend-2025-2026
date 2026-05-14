package mk.ukim.finki.eshopbackend.model.exception;

public class CartItemNotInCartException extends RuntimeException {
    public CartItemNotInCartException(Long productId) {
        super("Product with id %d is not in the cart.".formatted(productId));
    }
}