package Task3;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class NotificationService {

    private final List<NotificationSender> senders;

    public NotificationService(List<NotificationSender> senders) {
        this.senders = senders;
    }

    public NotificationResult notify(User user, String message) {

        List<String> failures = new ArrayList<>();

        for (NotificationType type : user.getPreferences()) {

            Optional<NotificationSender> senderOptional = senders.stream()
                    .filter(sender -> sender.getType() == type)
                    .findFirst();

            if (senderOptional.isEmpty()) {

                continue;
            }

            NotificationSender sender = senderOptional.get();

            System.out.println("Trying " + type + "...");

            NotificationResult result = sender.send(user, message);

            if (result.isSuccess()) {
                System.out.println(result.getMessage());
                return result;
            } else {
                System.out.println(type + " failed: " + result.getMessage());
                System.out.println();
                failures.add(type + ": " + result.getMessage());
            }
        }


        StringBuilder errorMessage = new StringBuilder("Notification could not be sent.");
        for (String failure : failures) {
            errorMessage.append(failure).append("\n");
        }

        throw new NotificationException(errorMessage.toString().trim());
    }
}
