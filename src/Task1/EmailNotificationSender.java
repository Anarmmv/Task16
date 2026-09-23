package Task1;

public class EmailNotificationSender implements NotificationSender{

    @Override
    public boolean send(String userId, String message) {
        System.out.println("EMAIL gonderildi: " + message);
        return true ;
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
