package mk.ukim.finki.eshopbackend.repository;

import mk.ukim.finki.eshopbackend.model.views.UserCartSummaryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCartSummaryViewRepository extends JpaRepository<UserCartSummaryView, Long> {
}
