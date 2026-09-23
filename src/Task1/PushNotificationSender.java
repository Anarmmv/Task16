package Task1;

public class PushNotificationSender implements NotificationSender {

    @Override
    public boolean send(String userId, String message) {
        System.out.println("PUSH gonderildi: " + message);
        return true ;
    }

    @Override
    public int getPriority() {
        return 3;
    }
}
