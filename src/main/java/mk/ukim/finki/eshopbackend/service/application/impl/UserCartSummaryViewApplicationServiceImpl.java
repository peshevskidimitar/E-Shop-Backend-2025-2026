package mk.ukim.finki.eshopbackend.service.application.impl;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.dto.DisplayUserCartSummaryViewDto;
import mk.ukim.finki.eshopbackend.service.application.UserCartSummaryViewApplicationService;
import mk.ukim.finki.eshopbackend.service.domain.UserCartSummaryViewService;
import org.springframework.stereotype.Service;

@Service
public class UserCartSummaryViewApplicationServiceImpl implements UserCartSummaryViewApplicationService {
    private final UserCartSummaryViewService userCartSummaryViewService;

    public UserCartSummaryViewApplicationServiceImpl(UserCartSummaryViewService userCartSummaryViewService) {
        this.userCartSummaryViewService = userCartSummaryViewService;
    }

    @Override
    public List<DisplayUserCartSummaryViewDto> findAll() {
        return DisplayUserCartSummaryViewDto.from(userCartSummaryViewService.findAll());
    }
}
