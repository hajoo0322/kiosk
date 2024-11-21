package kiosk.lv4;

public class Main {


    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.setMenu();
        boolean goStop = true;
        while(goStop) {
            goStop = kiosk.startKiosk();
        }
    }
}
