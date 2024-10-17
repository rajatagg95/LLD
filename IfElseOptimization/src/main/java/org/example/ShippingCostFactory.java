package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class ShippingCostFactory {

    private static final Map<ShippingTypeEnum, ShippingCostStrategy> strategies = new HashMap<>();

    static {
        strategies.put(ShippingTypeEnum.STANDARD, new StandardShipping());
        strategies.put(ShippingTypeEnum.EXPRESS, new ExpressShipping());
        strategies.put(ShippingTypeEnum.SAME_DAY, new SameDayShipping());
        strategies.put(ShippingTypeEnum.INTERNATIONAL, new InternationalShipping());
        strategies.put(ShippingTypeEnum.OVERNIGHT, new OvernightShipping());
    }



    public static ShippingCostStrategy getShippingCostStrategy(ShippingTypeEnum shippingType){
        return strategies.get(shippingType);
    }

}
