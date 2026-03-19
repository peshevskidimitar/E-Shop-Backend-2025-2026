package mk.ukim.finki.eshopbackend.web.controller;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.dto.DisplayUserCartSummaryViewDto;
import mk.ukim.finki.eshopbackend.service.application.UserCartSummaryViewApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-cart-summary")
public class UserCartSummaryViewController {
    private final UserCartSummaryViewApplicationService userCartSummaryViewApplicationService;

    public UserCartSummaryViewController(UserCartSummaryViewApplicationService userCartSummaryViewApplicationService) {
        this.userCartSummaryViewApplicationService = userCartSummaryViewApplicationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DisplayUserCartSummaryViewDto>> findAll() {
        return ResponseEntity.ok(userCartSummaryViewApplicationService.findAll());
    }
}
