package org.example;

public class StandardShipping implements ShippingCostStrategy {
    @Override
    public double calculate(double weight) {
        return weight * 5.0;
    }


    @Override
    public ShippingTypeEnum getType() {
        return ShippingTypeEnum.STANDARD;
    }
}
