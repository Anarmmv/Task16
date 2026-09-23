package Task2;

import java.util.List;

public class User {
    private String id;
    private List<NotificationType> preferredNotifications;

    public User(String id, List<NotificationType> preferredNotifications) {
        this.id = id;
        this.preferredNotifications = preferredNotifications;
    }

    public String getId() {
        return id;
    }

    public List<NotificationType> getPreferredNotifications() {
        return preferredNotifications;
    }
}
