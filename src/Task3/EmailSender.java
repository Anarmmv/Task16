package Task3;

public class EmailSender implements NotificationSender{
    private final boolean forceFail;

    public EmailSender(boolean forceFail) {
        this.forceFail = forceFail;
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }

    @Override
    public NotificationResult send(User user, String message) {
        if (forceFail) {
            return new NotificationResult(false, "Invalid email address");
        }
        return new NotificationResult(true, "Email notification sent successfully.");
    }

}
