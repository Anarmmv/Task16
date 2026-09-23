package Task4;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user = new User("u1", List.of(
                NotificationType.PUSH,
                NotificationType.SMS,
                NotificationType.EMAIL
        ));


        List<NotificationSender> senders = List.of(
                new PushNotificationSender(true),
                new SmsNotificationSender(true),
                new EmailNotificationSender(false)  
        );

        NotificationService service = new NotificationService(senders);

        try {
            NotificationResult result = service.notify(user, "Salam!");
            System.out.println("Uğurlu: " + result.getMessage());
        } catch (NotificationException e) {
            System.out.println("XƏTA:\n" + e.getMessage());
        }

        System.out.println("----------------------------------");


        List<NotificationSender> allFail = List.of(
                new PushNotificationSender(true),
                new SmsNotificationSender(true),
                new EmailNotificationSender(true)
        );

        NotificationService failingService = new NotificationService(allFail);

        try {
            failingService.notify(user, "Test");
        } catch (NotificationException e) {
            System.out.println("XƏTA:\n" + e.getMessage());
        }
    }
}
