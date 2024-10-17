package org.example;

public class InternationalShipping  implements ShippingCostStrategy{
    @Override
    public double calculate(double weight) {
        return weight * 50.0;
    }


    @Override
    public ShippingTypeEnum getType() {
        return ShippingTypeEnum.INTERNATIONAL;
    }
}
