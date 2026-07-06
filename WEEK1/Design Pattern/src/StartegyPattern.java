public class StartegyPattern {
    interface PaymentStrategy {
        void pay(double amount);
    }
    static class CreditCardPayment implements PaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using Credit Card.");
        }
    }
    static class PayPalPayment implements PaymentStrategy {

        @Override
        public void pay(double amount) {
            System.out.println("Paid Rs." + amount + " using PayPal.");
        }
    }
    static class PaymentContext {

        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void makePayment(double amount) {
            if (paymentStrategy == null) {
                System.out.println("Please select a payment method.");
            } else {
                paymentStrategy.pay(amount);
            }
        }
    }
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();
        context.setPaymentStrategy(new CreditCardPayment());
        context.makePayment(2500);
        context.setPaymentStrategy(new PayPalPayment());
        context.makePayment(1800);
    }
}
