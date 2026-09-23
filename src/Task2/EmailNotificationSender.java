package Task2;

public class EmailNotificationSender implements NotificationSender{
    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }

    @Override
    public boolean send(User user, String message) {
        System.out.println("EMAIL gonderildi: " + message + "user: "+ user.getId() );
        return true;
    }
}
