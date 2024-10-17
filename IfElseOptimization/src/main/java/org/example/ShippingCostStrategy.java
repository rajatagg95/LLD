package org.example;

public interface ShippingCostStrategy {

    public double calculate(double weight);
    public ShippingTypeEnum getType();
}
