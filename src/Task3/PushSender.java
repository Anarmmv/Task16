package Task3;

public class PushSender implements NotificationSender{
    private final boolean forceFail;

    public PushSender(boolean forceFail) {
        this.forceFail = forceFail;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.PUSH;
    }

    @Override
    public NotificationResult send(User user, String message) {
        if (forceFail) {
            return new NotificationResult(false, "Push server timeout");
        }
        return new NotificationResult(true, "Push notification sent successfully.");
    }
}
