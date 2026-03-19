package mk.ukim.finki.eshopbackend.model.dto;

import java.math.BigDecimal;
import java.util.List;
import mk.ukim.finki.eshopbackend.model.views.UserCartSummaryView;

public record DisplayUserCartSummaryViewDto(
    String fullName,
    String email,
    Integer totalItems,
    Integer totalQuantity,
    BigDecimal totalPrice
) {
    public static DisplayUserCartSummaryViewDto from(UserCartSummaryView userCartSummaryView) {
        return new DisplayUserCartSummaryViewDto(
            userCartSummaryView.getFullName(),
            userCartSummaryView.getEmail(),
            userCartSummaryView.getTotalItems(),
            userCartSummaryView.getTotalQuantity(),
            userCartSummaryView.getTotalPrice()
        );
    }

    public static List<DisplayUserCartSummaryViewDto> from(List<UserCartSummaryView> userCartSummaryViews) {
        return userCartSummaryViews
            .stream()
            .map(DisplayUserCartSummaryViewDto::from)
            .toList();
    }
}
