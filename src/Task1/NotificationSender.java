package Task1;

public interface NotificationSender {

    boolean send(String userId, String message);

    int getPriority();

}
