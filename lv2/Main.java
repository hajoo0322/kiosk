package kiosk.lv2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<MenuItem> menuPan = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        MenuItem menuItem1 = new MenuItem("ShackBurger"  , 6.9 , "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem2 = new MenuItem("SmokeShack "  , 8.9 , "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem3 = new MenuItem("Cheeseburger"  , 6.9 , "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem menuItem4 = new MenuItem("Hamburger"  , 5.4 , "비프패티를 기반으로 야채가 들어간 기본버거");
        menuPan.add(menuItem1);
        menuPan.add(menuItem2);
        menuPan.add(menuItem3);
        menuPan.add(menuItem4);


        while (true) {
            System.out.println("1. shackBurger");
            System.out.println("2. SmokeShack");
            System.out.println("3. CheeseBurger");
            System.out.println("4. Hamburger");
            System.out.println("0. 종료");

        String num = sc.next();
            if (num.equals("0")) {
                System.out.println("시스템 컷");
                break;
            } else if (num.equals("1")) {
                menuPan.get(0).showMenu();
            } else if (num.equals("2")) {
                menuPan.get(1).showMenu();
            } else if (num.equals("3")) {
                menuPan.get(2).showMenu();
            } else if (num.equals("4")) {
                menuPan.get(3).showMenu();
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력하세요");
                continue;
            }
        }
    }
}
