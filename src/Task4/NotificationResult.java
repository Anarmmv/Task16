package Task4;

public class NotificationResult {

    private boolean success;
    private String message;

    public NotificationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
