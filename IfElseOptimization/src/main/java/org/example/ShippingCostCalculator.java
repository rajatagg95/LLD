package org.example;

import java.util.HashMap;
import java.util.Map;

public class ShippingCostCalculator {

    /*

      using if else

     */

//    public double calculateCost(String shippingType , double weight){
//        if (shippingType.equals("STANDARD")) {
//            return weight * 5.0;
//        } else if (shippingType.equals("EXPRESS")) {
//            return weight * 10.0;
//        } else if (shippingType.equals("SAME_DAY")) {
//            return weight * 20.0;
//        } else if (shippingType.equals("INTERNATIONAL")) {
//            return weight * 50.0;
//        } else if (shippingType.equals("OVERNIGHT")) {
//            return weight * 30.0;
//        }
//        return 0;
//    }


    /*
    using enums
     */
//        public double calculateCost(ShippingTypeEnum shippingType , double weight){
//            return shippingType.getCost(weight);
//    }

    /*
   using factory
     */

//        public double calculateCost(ShippingTypeEnum shippingType , double weight){
//            ShippingCostStrategy shippingCostStrategy = ShippingCostFactory.getShippingCostStrategy(shippingType);
//            return shippingCostStrategy.calculate(weight);
//    }


    /*
    using strategy
     */

//    private static final Map<ShippingTypeEnum, ShippingCostStrategy> strategies = new HashMap<>();
//
//    static {
//        strategies.put(ShippingTypeEnum.STANDARD, new StandardShipping());
//        strategies.put(ShippingTypeEnum.EXPRESS, new ExpressShipping());
//        strategies.put(ShippingTypeEnum.SAME_DAY, new SameDayShipping());
//        strategies.put(ShippingTypeEnum.INTERNATIONAL, new InternationalShipping());
//        strategies.put(ShippingTypeEnum.OVERNIGHT, new OvernightShipping());
//    }
//
//    private final ShippingCostContext context = new ShippingCostContext();
//
//        public double calculateCost(ShippingTypeEnum shippingType , double weight){
//        ShippingCostStrategy shippingCostStrategy = strategies.get(shippingType);
//        context.setStrategy(shippingCostStrategy);
//        return context.calculateShippingCost(weight);
//    }

}
