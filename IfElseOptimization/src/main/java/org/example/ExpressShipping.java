package org.example;

public class ExpressShipping implements ShippingCostStrategy {


    @Override
    public double calculate(double weight) {
        return weight * 10.0;
    }

    @Override
    public ShippingTypeEnum getType() {
        return ShippingTypeEnum.EXPRESS;
    }
}
