package kiosk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        boolean goStop = true;
        while(goStop) {
            kiosk.viewMenu();

            Scanner sc = new Scanner(System.in);
            int num1 = sc.nextInt();
            if (num1 == 0) {
                goStop = false;
            } else if (num1 >3){

            }
            kiosk.selectFood(num1);
        }
    }
}
