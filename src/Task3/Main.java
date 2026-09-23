package Task3;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user = new User("Anar", List.of(
                NotificationType.PUSH,
                NotificationType.EMAIL,
                NotificationType.SMS
        ));


        List<NotificationSender> senders = List.of(
                new PushSender(true),
                new EmailSender(true),
                new SmsSender(false)
        );

        NotificationService service = new NotificationService(senders);

        try {
            NotificationResult result = service.notify(user, "Salam, sifarişiniz hazırdır!");
            System.out.println("Nəticə: " + result.isSuccess());
        } catch (NotificationException e) {
            System.out.println("XƏTA: " + e.getMessage());
        }

        System.out.println("----------------------------------");


        List<NotificationSender> allFailSenders = List.of(
                new PushSender(true),
                new EmailSender(true),
                new SmsSender(true)
        );

        NotificationService failingService = new NotificationService(allFailSenders);

        try {
            failingService.notify(user, "Test mesajı");
        } catch (NotificationException e) {
            System.out.println("XƏTA: " + e.getMessage());
        }
    }
}
