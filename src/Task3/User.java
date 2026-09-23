package Task3;

import java.util.List;

public class User {
    private String name;
    private List<NotificationType> preferences;

    public User(String name, List<NotificationType> preferences) {
        this.name = name;
        this.preferences = preferences;
    }

    public String getName() {
        return name;
    }

    public List<NotificationType> getPreferences() {
        return preferences;
    }
}
