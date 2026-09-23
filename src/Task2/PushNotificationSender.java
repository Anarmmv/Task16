package Task2;

public class PushNotificationSender implements NotificationSender{
    @Override
    public NotificationType getType() {
        return NotificationType.PUSH;
    }

    @Override
    public boolean send(User user, String message) {
        System.out.println("PUSH gonderildi: " + message + "user: "+ user.getId() );
        return true;
    }
}
