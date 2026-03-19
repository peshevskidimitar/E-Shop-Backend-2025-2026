package mk.ukim.finki.eshopbackend.service.domain.impl;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.views.UserCartSummaryView;
import mk.ukim.finki.eshopbackend.repository.UserCartSummaryViewRepository;
import mk.ukim.finki.eshopbackend.service.domain.UserCartSummaryViewService;
import org.springframework.stereotype.Service;

@Service
public class UserCartSummaryViewServiceImpl implements UserCartSummaryViewService {
    private final UserCartSummaryViewRepository userCartSummaryViewRepository;

    public UserCartSummaryViewServiceImpl(UserCartSummaryViewRepository userCartSummaryViewRepository) {
        this.userCartSummaryViewRepository = userCartSummaryViewRepository;
    }

    @Override
    public List<UserCartSummaryView> findAll() {
        return userCartSummaryViewRepository.findAll();
    }
}
