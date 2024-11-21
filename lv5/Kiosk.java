package kiosk.lv5;

import kiosk.myexception.WrongNumberException;

import java.util.Scanner;

public class Kiosk {
    private String[] menupan = {"새우버거", "치킨버거", "삼촌손버거"};
    Scanner sc = new Scanner(System.in);
    private Menu menu = new Menu();
        public void startKiosk() {

        while (true) {
            viewMenu();
            String num = sc.next();
            if (num.equals("0")) {
                System.out.println("시스템 캇~!");
                break;
            }
            try {
                menu.selectMenu(num);
            } catch (WrongNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void viewMenu() {
        int i = 1;
        for (String string : menupan) {
            System.out.println(i + ". " + string);
            i++;
        }
        System.out.println("0. 종료");
    }
}


