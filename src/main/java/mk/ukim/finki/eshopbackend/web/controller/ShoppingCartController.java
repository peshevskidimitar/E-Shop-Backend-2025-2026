package mk.ukim.finki.eshopbackend.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.eshopbackend.model.domain.User;
import mk.ukim.finki.eshopbackend.model.dto.AddToShoppingCartDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayShoppingCartDto;
import mk.ukim.finki.eshopbackend.service.application.ShoppingCartApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {
    private final ShoppingCartApplicationService shoppingCartApplicationService;

    public ShoppingCartController(ShoppingCartApplicationService shoppingCartApplicationService) {
        this.shoppingCartApplicationService = shoppingCartApplicationService;
    }

    @GetMapping
    public ResponseEntity<DisplayShoppingCartDto> findByUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(shoppingCartApplicationService.findByUser(user));
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayShoppingCartDto> addToShoppingCart(
        @AuthenticationPrincipal User user,
        @RequestBody @Valid AddToShoppingCartDto addToShoppingCartDto
    ) {
        return ResponseEntity.ok(shoppingCartApplicationService.addToShoppingCart(user, addToShoppingCartDto));
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<DisplayShoppingCartDto> removeFromShoppingCart(
        @AuthenticationPrincipal User user,
        @PathVariable Long productId
    ) {
        return ResponseEntity.ok(shoppingCartApplicationService.removeFromShoppingCart(user, productId));
    }

    @PostMapping("/checkout")
    public ResponseEntity<Void> checkout(@AuthenticationPrincipal User user) {
        shoppingCartApplicationService.checkout(user);
        return ResponseEntity.ok().build();
    }
}