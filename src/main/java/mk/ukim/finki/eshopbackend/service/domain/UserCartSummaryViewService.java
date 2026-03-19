package mk.ukim.finki.eshopbackend.service.domain;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.views.UserCartSummaryView;

public interface UserCartSummaryViewService {
    List<UserCartSummaryView> findAll();
}
