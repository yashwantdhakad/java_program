package example.corejava.designpatterns;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Pay ₹" + amount + " by credit card");
    }
}

class GPayPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Pay ₹" + amount + " by GPay");
    }
}
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void payBy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("PaymentStrategy not set!");
        }
        paymentStrategy.pay(amount);
    }
}
public class StrategyPattern {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.payBy(new CreditCardPayment());
        context.makePayment(1000);

        context.payBy(new GPayPayment());
        context.makePayment(500);
    }
}
