public class DecoratorPattern {

    interface Notifier {
        void send(String message);
    }

    static class EmailNotifier implements Notifier {

        @Override
        public void send(String message) {
            System.out.println("Email Notification: " + message);
        }
    }

    static abstract class NotifierDecorator implements Notifier {

        protected Notifier notifier;

        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        @Override
        public void send(String message) {
            notifier.send(message);
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {

        public SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            System.out.println("SMS Notification: " + message);
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {

        public SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void send(String message) {
            super.send(message);
            System.out.println("Slack Notification: " + message);
        }
    }

    public static void main(String[] args) {

        System.out.println("----- Email Only -----");
        Notifier email = new EmailNotifier();
        email.send("Your order has been placed.");

        System.out.println();

        System.out.println("----- Email + SMS -----");
        Notifier emailSMS = new SMSNotifierDecorator(new EmailNotifier());
        emailSMS.send("Your payment is successful.");

        System.out.println();

        System.out.println("----- Email + SMS + Slack -----");
        Notifier allNotifications =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifications.send("Your package has been delivered.");
    }
}
