package Task2;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class NotificationService {
    Map<NotificationType, NotificationSender> senderMap;

    public NotificationService(Map<NotificationType, NotificationSender> senderMap) {
        this.senderMap = senderMap;
    }

    public void sendNotification(User user, String message) {
        List<NotificationType> preferences = user.getPreferredNotifications();
        for (NotificationType type : preferences){
            Optional<NotificationSender>optionalSender = findSender()
        }


    }
}
