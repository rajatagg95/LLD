package org.example;

public class OvernightShipping  implements ShippingCostStrategy{
    @Override
    public double calculate(double weight) {
        return weight * 30.0;
    }

    @Override
    public ShippingTypeEnum getType() {
        return ShippingTypeEnum.OVERNIGHT;
    }
}
