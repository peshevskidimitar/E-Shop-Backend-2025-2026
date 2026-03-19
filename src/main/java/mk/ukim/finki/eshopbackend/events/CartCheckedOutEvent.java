package mk.ukim.finki.eshopbackend.events;

import mk.ukim.finki.eshopbackend.model.domain.ShoppingCart;

public record CartCheckedOutEvent(ShoppingCart shoppingCart, String userEmail) {
}
