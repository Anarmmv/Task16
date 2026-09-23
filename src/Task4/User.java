package Task4;

import java.util.List;

public class User {

    private String id;
    private List<NotificationType> notificationPriority;

    public User(String id, List<NotificationType> notificationPriority) {
        this.id = id;
        this.notificationPriority = notificationPriority;
    }

    public String getId() {
        return id;
    }

    public List<NotificationType> getNotificationPriority() {
        return notificationPriority;
    }

    public void setNotificationPriority(List<NotificationType> notificationPriority) {
        this.notificationPriority = notificationPriority;
    }
}
