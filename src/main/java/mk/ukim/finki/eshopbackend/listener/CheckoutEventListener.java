package mk.ukim.finki.eshopbackend.listener;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.eshopbackend.events.CartCheckedOutEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class CheckoutEventListener {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    public void onCartCheckedOut(CartCheckedOutEvent event) {
        log.info("[ASYNC - thread: {}] Sending confirmation email to '{}'.", Thread.currentThread().getName(),
            event.userEmail());

        simulateSendEmail(event);
    }

    private void simulateSendEmail(CartCheckedOutEvent event) {
        try {
            Thread.sleep(2000);
            log.info("Email sent to '{}'.", event.userEmail());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
