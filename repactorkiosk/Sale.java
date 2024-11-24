package kiosk.repactorkiosk;

public enum Sale {
    SOLIDER{
        @Override //
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
//코드 확장성을 향상시켜서 완전히 다른 할인항목이 생겨도 간단히 추가할수있다.
    public abstract double saleCalculate(double sum);
}
