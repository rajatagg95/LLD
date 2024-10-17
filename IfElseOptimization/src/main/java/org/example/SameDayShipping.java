package org.example;

public class SameDayShipping  implements ShippingCostStrategy{
    @Override
    public double calculate(double weight) {
        return weight * 20.0;
    }


    @Override
    public ShippingTypeEnum getType() {
        return ShippingTypeEnum.SAME_DAY;
    }
}
