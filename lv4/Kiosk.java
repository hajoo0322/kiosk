package kiosk.lv4;

import kiosk.myexception.WrongNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    String[] menupan = {"버거", "마실거", "주전부리"};
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();

    public void startKiosk() {

        while (true) {
            menu.whatType.clear();
            viewMenu();
            String num = sc.next();
            if (isThisZero(num)) {
                break;
            }
            try {
                selectMenu(num);
            } catch (WrongNumberException e) {
                System.out.println(e.getMessage());
                continue;
            }
            menu.showMenu();
            String num2 = sc.next();
            try {
                menu.setMenu(num2);
            } catch (Exception e) {
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

    public void selectMenu(String num) throws WrongNumberException {

        if (num.equals("1")) {
            MenuItem a= new MenuItem("새우버거",92,"게맛살,새우깡,마요네즈,근처에 있던잡초로 만든버거");
            MenuItem b = new MenuItem("치킨버거", 85, "옆집KFC에서 튀기고 남은 짜투리를 뭉쳐서 만든버거");
            MenuItem c = new MenuItem("삼촌손버거", 394, "삼촌이 한땀한땀 손으로 뭉쳐준 패티가 들어간 버거");
            Collections.addAll(menu.whatType, a, b, c);
        } else if (num.equals("2")) {
            MenuItem a= new MenuItem("콜라",150,"마당에 장독대에 담가둔 간장");
            MenuItem b = new MenuItem("사이다", 90,"이게 진짜 사이다");
            MenuItem c = new MenuItem("진짜 사이다", 150,"스프라이트");
            Collections.addAll(menu.whatType, a, b, c);
        } else if (num.equals("3")) {
            MenuItem a = new MenuItem("감자튀김",50.4,"잘튀긴 동그란 감자");
            MenuItem b = new MenuItem("치즈 스틱", 30.1,"치즈 없는 치즈스틱");
            MenuItem c = new MenuItem("훈제 닭다리", 89.9, "훈제한 닭다리");
            Collections.addAll(menu.whatType, a, b, c);
        } else {
            throw new WrongNumberException();
        }
    }

    public boolean isThisZero(String num) {
        if (num.equals("0")) {
            System.out.println("시스템 캇~!");
            return true;
        }
        return false;
    }
}


