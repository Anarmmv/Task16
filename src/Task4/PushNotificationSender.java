package Task4;

import java.util.Optional;

public class PushNotificationSender implements NotificationSender {

    private final boolean throwException;

    public PushNotificationSender(boolean throwException) {
        this.throwException = throwException;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.PUSH;
    }

    @Override
    public Optional<NotificationResult> send(User user, String message) {
        if (throwException) {
            throw new RuntimeException("Push server timeout");
        }
        return Optional.of(new NotificationResult(true, "Push notification sent successfully."));
    }
}