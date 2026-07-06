public class AdapterPattern {

    interface PaymentProcessor {
        void processPayment(double amount);
    }

    static class PayPalGateway {
        public void makePayment(double amount) {
            System.out.println("Payment of Rs." + amount + " processed using PayPal.");
        }
    }

    static class StripeGateway {
        public void payAmount(double amount) {
            System.out.println("Payment of Rs." + amount + " processed using Stripe.");
        }
    }

    static class RazorpayGateway {
        public void sendPayment(double amount) {
            System.out.println("Payment of Rs." + amount + " processed using Razorpay.");
        }
    }

    static class PayPalAdapter implements PaymentProcessor {
        private PayPalGateway paypal = new PayPalGateway();

        @Override
        public void processPayment(double amount) {
            paypal.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripeGateway stripe = new StripeGateway();

        @Override
        public void processPayment(double amount) {
            stripe.payAmount(amount);
        }
    }

    static class RazorpayAdapter implements PaymentProcessor {
        private RazorpayGateway razorpay = new RazorpayGateway();

        @Override
        public void processPayment(double amount) {
            razorpay.sendPayment(amount);
        }
    }

    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter();
        paypal.processPayment(1000);

        PaymentProcessor stripe = new StripeAdapter();
        stripe.processPayment(2000);

        PaymentProcessor razorpay = new RazorpayAdapter();
        razorpay.processPayment(3000);
    }
}
