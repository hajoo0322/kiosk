package kiosk.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    String[] menupan = {"새우버거", "치킨버거", "삼촌손버거"};
    MenuItem seuBurger = new MenuItem("새우버거",92,"게맛살,새우깡,마요네즈,근처에 있던잡초로 만든버거");
    MenuItem chickenBurger = new MenuItem("치킨버거", 85, "옆집KFC에서 튀기고 남은 짜투리를 뭉쳐서 만든버거");
    MenuItem samchonBurger = new MenuItem("삼촌손버거", 394, "삼촌이 한땀한땀 손으로 뭉쳐준 패티가 들어간 버거");
    Scanner sc = new Scanner(System.in);
    List<MenuItem> menuItems = new ArrayList<>();

    public void startKiosk() {
        setDetailMenu();
        while (true) {
            viewMenu();
            String num = sc.next();
            if (num.equals("0")) {
                break;
            }else if (num.equals("1")) {
                menuItems.get(0).showMenu();
            } else if (num.equals("2")) {
                menuItems.get(1).showMenu();
            } else if (num.equals("3")) {
                menuItems.get(2).showMenu();
            } else {
                System.out.println("잘못된 입력입니다.");
            }

        }
    }

    private void setDetailMenu() {
        menuItems.add(seuBurger);
        menuItems.add(chickenBurger);
        menuItems.add(samchonBurger);

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


