package org.example;

public enum ShippingTypeEnum {

    STANDARD{
        @Override
        public double getCost(double weight){
            return weight * 5.0;
        }
    },
    EXPRESS{
        @Override
        public double getCost(double weight){
            return weight * 5.0;
        }
    },
    SAME_DAY{
        @Override
        public double getCost(double weight){
            return weight * 5.0;
        }
    },
    INTERNATIONAL{
        @Override
        public double getCost(double weight){
            return weight * 5.0;
        }
    },
    OVERNIGHT{
        @Override
        public double getCost(double weight){
            return weight * 5.0;
        }
    };

    public abstract double getCost(double weight);
}
