package mk.ukim.finki.eshopbackend.service.application;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.dto.DisplayUserCartSummaryViewDto;

public interface UserCartSummaryViewApplicationService {
    List<DisplayUserCartSummaryViewDto> findAll();
}
