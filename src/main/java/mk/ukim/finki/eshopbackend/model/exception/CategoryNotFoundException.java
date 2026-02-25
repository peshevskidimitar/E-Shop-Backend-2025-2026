package mk.ukim.finki.eshopbackend.model.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super("A category with id %d does not exist.".formatted(id));
    }
}
