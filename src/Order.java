import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private List<OrderObserver> observers = new ArrayList<>();
    private int itemCount = 0;
    private double itemCost = 0.0;
    private double totalPrice = 0.0;
    private double shippingCost = 10.0;

    public Order(int id) {
        this.id = id;
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void addItem(double price) {
        itemCount++;
        itemCost += price;
        totalPrice = itemCost + shippingCost;
        notifyObservers();
    }

    public int getCount() {
        return itemCount;
    }

    public double getItemCost() {
        return itemCost;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double price) {
        this.totalPrice = price;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double cost) {
        this.shippingCost = cost;
    }

    @Override
    public String toString() {
        return "Order #" + id +
                "\nItems: " + itemCount +
                "\nItem Cost: $" + itemCost +
                "\nShipping Cost: $" + shippingCost +
                "\nTotal Price: $" + totalPrice + "\n";
    }
}
