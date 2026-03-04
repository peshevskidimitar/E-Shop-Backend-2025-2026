package mk.ukim.finki.eshopbackend.repository;

import jakarta.transaction.Transactional;
import java.util.List;
import mk.ukim.finki.eshopbackend.config.JpaConfig;
import mk.ukim.finki.eshopbackend.model.domain.User;
import mk.ukim.finki.eshopbackend.model.projection.UserProjection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaConfig.class)
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.save(new User("Alice", "Smith", "alice.smith@example.com"));
        userRepository.save(new User("Bob", "Jones", "bob.jones@example.com"));
    }

    @Test
    void testFindAllWithNameSurnameAndEmail() {
        List<UserProjection> results = userRepository.findAllWithNameSurnameAndEmail();

        assertThat(results).hasSize(2);

        assertThat(results).anySatisfy(p -> {
            assertThat(p.getName()).isEqualTo("Alice");
            assertThat(p.getSurname()).isEqualTo("Smith");
            assertThat(p.getEmail()).isEqualTo("alice.smith@example.com");
        });

        assertThat(results).anySatisfy(p -> {
            assertThat(p.getName()).isEqualTo("Bob");
            assertThat(p.getSurname()).isEqualTo("Jones");
            assertThat(p.getEmail()).isEqualTo("bob.jones@example.com");
        });
    }
}
