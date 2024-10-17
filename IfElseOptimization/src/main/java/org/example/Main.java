package org.example;

public class Main {

    public static void main(String[] args) {
       ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();

//       way1: using if else
//       System.out.println(shippingCostCalculator.calculateCost("STANDARD",5));

//        way2: using enums
//        System.out.println(shippingCostCalculator.calculateCost(ShippingTypeEnum.STANDARD,5));

//        way3: using factory pattern
//        System.out.println(shippingCostCalculator.calculateCost(ShippingTypeEnum.STANDARD,5));


//        way4: using stratgey along with factory
//        System.out.println(shippingCostCalculator.calculateCost(ShippingTypeEnum.STANDARD,5));



        //////////////////////////////////////////////////////////////////

        /*

        /////strategy pattern

        public interface PaymentStrategy {
    void pay(double amount);
}

public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid by credit card: " + amount);
    }
}

public class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid by PayPal: " + amount);
    }
}

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double amount) {
        paymentStrategy.pay(amount);
    }
}



///// factory pattern

public interface Notification {
    void notifyUser();
}

public class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an email notification");
    }
}

public class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending an SMS notification");
    }
}

public class NotificationFactory {
    public static Notification createNotification(String channel) {
        if (channel.equals("EMAIL")) {
            return new EmailNotification();
        } else if (channel.equals("SMS")) {
            return new SMSNotification();
        }
        throw new IllegalArgumentException("Unknown channel " + channel);
    }
}




/////combining both factory and strategy


public interface NotificationStrategy {
    void sendNotification(Notification notification);
}

public class InstantDeliveryStrategy implements NotificationStrategy {
    public void sendNotification(Notification notification) {
        notification.notifyUser();  // Sends immediately
    }
}

public class BatchDeliveryStrategy implements NotificationStrategy {
    public void sendNotification(Notification notification) {
        // Logic to batch notifications
        notification.notifyUser();
    }
}

public class NotificationService {
    private NotificationFactory notificationFactory;
    private NotificationStrategy notificationStrategy;

    public NotificationService(NotificationFactory factory, NotificationStrategy strategy) {
        this.notificationFactory = factory;
        this.notificationStrategy = strategy;
    }

    public void notifyUser(String channel) {
        Notification notification = notificationFactory.createNotification(channel);
        notificationStrategy.sendNotification(notification);
    }
}


Summary:
Strategy Pattern is a behavioral pattern that allows you to choose algorithms dynamically.
Factory Pattern is a creational pattern that helps you create objects without exposing the logic behind it.
Use Strategy when you want interchangeable behaviors or algorithms.
Use Factory when you want to decouple the instantiation of objects from their usage.
Both patterns can be combined when your system needs dynamic object creation and flexible behavior at runtime.


         */






    }
}