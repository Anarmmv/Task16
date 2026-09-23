package Task3;

public class SmsSender implements NotificationSender{
    private final boolean forceFail;

    public SmsSender(boolean forceFail) {
        this.forceFail = forceFail;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }

    @Override
    public NotificationResult send(User user, String message) {
        if (forceFail) {
            return new NotificationResult(false, "SMS provider unavailable");
        }
        return new NotificationResult(true, "SMS notification sent successfully.");
    }
}
