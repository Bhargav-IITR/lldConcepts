package org.example.strategyPattern;

public class Order {
    private final double totalWeight;
    private final String destinationZone;
    private final double orderValue;

    public Order(double totalWeight, String destinationZone, double orderValue) {
        this.totalWeight = totalWeight;
        this.destinationZone = destinationZone;
        this.orderValue = orderValue;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public String getDestinationZone() {
        return destinationZone;
    }

    public double getOrderValue() {
        return orderValue;
    }
}
