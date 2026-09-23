package Task4;

import java.util.Optional;

public class SmsNotificationSender implements NotificationSender {

    private final boolean forceFail;

    public SmsNotificationSender(boolean forceFail) {
        this.forceFail = forceFail;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }

    @Override
    public Optional<NotificationResult> send(User user, String message) {
        if (forceFail) {
            return Optional.of(new NotificationResult(false, "SMS provider unavailable"));
        }
        return Optional.of(new NotificationResult(true, "SMS notification sent successfully."));
    }
}
