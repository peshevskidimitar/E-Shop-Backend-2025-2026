package mk.ukim.finki.eshopbackend.web.handler;

import mk.ukim.finki.eshopbackend.model.exception.CategoryNotFoundException;
import mk.ukim.finki.eshopbackend.web.controller.ProductController;
import mk.ukim.finki.eshopbackend.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = ProductController.class)
public class ProductControllerExceptionHandler {
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(CategoryNotFoundException exception) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
