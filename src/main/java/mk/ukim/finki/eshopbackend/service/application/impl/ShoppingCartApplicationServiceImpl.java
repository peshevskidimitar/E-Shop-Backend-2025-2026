package mk.ukim.finki.eshopbackend.service.application.impl;

import mk.ukim.finki.eshopbackend.model.domain.ShoppingCart;
import mk.ukim.finki.eshopbackend.model.domain.User;
import mk.ukim.finki.eshopbackend.model.dto.AddToShoppingCartDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayShoppingCartDto;
import mk.ukim.finki.eshopbackend.model.exception.ShoppingCartNotFoundException;
import mk.ukim.finki.eshopbackend.repository.ShoppingCartRepository;
import mk.ukim.finki.eshopbackend.service.application.ShoppingCartApplicationService;
import mk.ukim.finki.eshopbackend.service.domain.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartApplicationServiceImpl implements ShoppingCartApplicationService {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartApplicationServiceImpl(
        ShoppingCartService shoppingCartService,
        ShoppingCartRepository shoppingCartRepository
    ) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public DisplayShoppingCartDto findByUser(User user) {
        return shoppingCartRepository.findWithCartItemsByUserId(user.getId())
            .map(DisplayShoppingCartDto::from)
            .orElseGet(() -> new DisplayShoppingCartDto(null, java.util.List.of()));
    }

    @Override
    public DisplayShoppingCartDto addToShoppingCart(User user, AddToShoppingCartDto addToShoppingCartDto) {
        return DisplayShoppingCartDto.from(
            shoppingCartService.addToShoppingCart(user, addToShoppingCartDto.productId(), addToShoppingCartDto.quantity())
        );
    }

    @Override
    public DisplayShoppingCartDto removeFromShoppingCart(User user, Long productId) {
        return DisplayShoppingCartDto.from(
            shoppingCartService.removeFromShoppingCart(user, productId)
        );
    }

    @Override
    public void checkout(User user) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(user.getId())
            .orElseThrow(() -> new ShoppingCartNotFoundException(user.getId()));
        shoppingCartService.checkout(shoppingCart.getId());
    }
}