package kiosk.repactorkiosk;

public class Main {

    public static void main(String[] args) {
        Kiosk kiosk2 = new Kiosk(new FoodFactory().menuPan);//푸드팩토리 클래스에서 메뉴 초기화 작업
        boolean goStop = true;           //kosikstart 메서드의 반복을 조절한다.
        while(goStop) {
            goStop = kiosk2.startKiosk();
        }
    }
}
