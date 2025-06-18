public class PriceObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getItemCost() > 200) {
            double discountedPrice = order.getItemCost() - 20.0 + order.getShippingCost();
            order.setTotalPrice(discountedPrice);
        } else {
            order.setTotalPrice(order.getItemCost() + order.getShippingCost());
        }
    }
}