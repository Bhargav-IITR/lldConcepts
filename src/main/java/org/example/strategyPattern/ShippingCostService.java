package org.example.strategyPattern;

public class ShippingCostService {
    private ShippingStrategy strategy;

    public ShippingCostService(ShippingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ShippingStrategy strategy) {
        System.out.println("ShippingCostService: Strategy changed to " + strategy.getClass().getSimpleName());
        this.strategy = strategy;
    }

    public double calculateShippingCost(Order order) {
        if (strategy == null) {
            throw new IllegalStateException("Shipping strategy not set.");
        }

        double cost = strategy.calculateCost(order);
        System.out.println(
                "ShippingCostService: Final Calculated Shipping Cost: $" + cost
                        + " (using " + strategy.getClass().getSimpleName() + ")"
        );
        return cost;
    }
}
