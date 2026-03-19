package mk.ukim.finki.eshopbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EShopBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(EShopBackendApplication.class, args);
    }
}
