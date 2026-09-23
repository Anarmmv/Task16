package Task1;

public class SmsNotificationSender implements NotificationSender{
    @Override
    public boolean send(String userId, String message) {
        System.out.println("SMS gonderildi: " + message);
        return true ;
    }

    @Override
    public int getPriority() {
        return 2;
    }
}
