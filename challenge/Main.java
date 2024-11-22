package kiosk.challenge;

public class Main {

    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.setMenu();
        boolean goStop = true;           //kosikstart 메서드의 반복을 조절한다.
        while(goStop) {
            goStop = kiosk.startKiosk();
        }
    }
}
