package mk.ukim.finki.eshopbackend.repository;

import java.util.List;
import mk.ukim.finki.eshopbackend.model.domain.User;
import mk.ukim.finki.eshopbackend.model.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select name, surname, email from users", nativeQuery = true)
    List<UserProjection> findAllWithNameSurnameAndEmail();
}
