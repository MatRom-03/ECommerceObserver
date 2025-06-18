public class Main {
    public static void main(String[] args) {
        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();

        Order order = new Order(1);  // Order ID 1 - Classic Order
        order.attach(priceObserver);
        order.attach(quantityObserver);

        order.addItem(50.0);
        order.addItem(30.0);
        order.addItem(60.0);

        System.out.println(order);

        order.detach(priceObserver);
        order.detach(quantityObserver);

        Order order2 = new Order(2); // Order ID 2 - Discount
        order2.attach(priceObserver);
        order2.attach(quantityObserver);

        order2.addItem(50.0);
        order2.addItem(30.0);
        order2.addItem(60.0);
        order2.addItem(70.0);

        System.out.println(order2);

        order2.detach(priceObserver);
        order2.detach(quantityObserver);

        Order order3 = new Order(3); // Order ID 3 - Free Shipping with Discount
        order3.attach(priceObserver);
        order3.attach(quantityObserver);

        order3.addItem(50.0);
        order3.addItem(30.0);
        order3.addItem(60.0);
        order3.addItem(70.0);
        order3.addItem(10.0);
        order3.addItem(15.0);

        System.out.println(order3);

        order3.detach(priceObserver);
        order3.detach(quantityObserver);
    }
}
