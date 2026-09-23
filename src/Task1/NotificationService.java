package Task1;

import com.sun.net.httpserver.Authenticator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NotificationService {

    List<NotificationSender> senders;


    public NotificationService(List<NotificationSender> senders) {
        this.senders = senders;
    }

    public void sendNotification(String userId, String message) {
        Optional<NotificationSender> successfulSender = senders.stream()
                .sorted(Comparator.comparing(NotificationSender::getPriority).reversed())
                .filter(sender -> sender.send(userId, message))
                .findFirst();
        if (successfulSender.isPresent()) {
            System.out.println("Notification successfully sent " + successfulSender.get().getClass().getSimpleName());
        } else {
            throw new NotificationException("All notificatio sender failed for user : " + userId);
        }
    }


    static void main(String[] args) {
        List<NotificationSender> senders = List.of(
                new EmailNotificationSender(),
                new SmsNotificationSender(),
                new PushNotificationSender()
        );

        NotificationService service = new NotificationService(senders);
        service.sendNotification("user123", "Salam!");
    }
}




