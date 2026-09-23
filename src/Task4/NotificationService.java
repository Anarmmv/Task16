package Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotificationService {

    private final List<NotificationSender> senders;

    public NotificationService(List<NotificationSender> senders) {
        this.senders = senders;
    }

    public NotificationResult notify(User user, String message) {

        List<String> failureReasons = new ArrayList<>();

        for (NotificationType type : user.getNotificationPriority()) {

            Optional<NotificationSender> senderOptional = findSenderByType(type);

            if (senderOptional.isEmpty()) {
                failureReasons.add(type + ": no sender registered for this type");
                continue;
            }

            NotificationSender sender = senderOptional.get();

            Optional<NotificationResult> resultOptional = trySend(sender, user, message);

            if (resultOptional.isEmpty()) {
                failureReasons.add(type + ": sender did not return a result");
                continue;
            }

            NotificationResult result = resultOptional.get();

            if (result.isSuccess()) {
                return result;
            }

            failureReasons.add(type + ": " + result.getMessage());
        }

        StringBuilder errorMessage = new StringBuilder("All notification attempts failed:\n");
        for (String reason : failureReasons) {
            errorMessage.append(reason).append("\n");
        }

        throw new NotificationException(errorMessage.toString().trim());
    }

    private Optional<NotificationSender> findSenderByType(NotificationType type) {
        return senders.stream()
                .filter(sender -> sender.getType() == type)
                .findFirst();
    }

    private Optional<NotificationResult> trySend(NotificationSender sender, User user, String message) {
        try {
            return sender.send(user, message);
        } catch (RuntimeException e) {

            return Optional.of(new NotificationResult(false, e.getMessage()));
        }
    }
}
