package Task4;

import java.util.Optional;

public class EmailNotificationSender implements NotificationSender {

    private final boolean forceFail;

    public EmailNotificationSender(boolean forceFail) {
        this.forceFail = forceFail;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }

    @Override
    public Optional<NotificationResult> send(User user, String message) {
        if (forceFail) {
            return Optional.of(new NotificationResult(false, "Invalid email address"));
        }
        return Optional.of(new NotificationResult(true, "Email notification sent successfully."));
    }
}
