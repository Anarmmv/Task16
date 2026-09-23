package Task2;

public class SmsNotificationSender implements NotificationSender {
    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }

    @Override
    public boolean send(User user, String message) {
        System.out.println("SMS gonderildi: " + message + "user: "+ user.getId() );
        return true;
    }
}
