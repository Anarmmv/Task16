package Task3;

public interface NotificationSender {
    NotificationType getType();

    NotificationResult send(User user, String message);
}
