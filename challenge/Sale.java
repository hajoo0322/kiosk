package kiosk.challenge;

public enum Sale {
    SOLIDER{
        @Override
        public double saleCalculate(double sum) {
            return sum-(sum*0.8);
        }
    }
    , SPRINGSTAGE4 {
        @Override
        public double saleCalculate(double sum) {
            return sum+(sum*2);
        }
    };


    public abstract double saleCalculate(double sum);
}
