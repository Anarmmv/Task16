package Task2;

public interface NotificationSender {
    NotificationType getType();

    boolean send(User user, String message);

}
