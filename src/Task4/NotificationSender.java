package Task4;

import java.util.Optional;

public interface NotificationSender {
    NotificationType getType();

    Optional<NotificationResult> send(User user, String message);
}
