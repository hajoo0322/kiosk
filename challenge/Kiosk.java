package kiosk.challenge;

import java.util.*;

public class Kiosk {
    List<Menu> menupan = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Menu menu1 = new Menu("햄버거");
    Menu menu2 = new Menu("마실거");
    Menu menu3 = new Menu("주전부리");
    Menu wantBucket = new Menu("장바구니");

    public boolean startKiosk() {
        if (wantBucket.wantItems.isEmpty()) {
            viewMenu();
        } else {
            viewMenuAndCash();
        }
        String num = sc.next();
        if (isThisZero(num)) {
            return false;
        }

        if (!wantBucket.wantItems.isEmpty()) {
            if (num.equals("4")) {
                return wantBucket.showSelectMenu();
            } else if (num.equals("5")) {
                wantBucket.areYouDelete();
                return true;
            }
        }


        if (num.equals("1")) {
            menu1.showMenu();
        } else if (num.equals("2")) {
            menu2.showMenu();
        } else if (num.equals("3")) {
            menu3.showMenu();
        } else {
            System.out.println("숫자가 잘못 입력됫소");
            return true;
        }


        String num2 = sc.next();
        if (num2.equals("0")) {
            System.out.println("뒤로갑니다");
            return true;
        } else if (num.equals("1")) {
            menu1.setMenu(num2);
            String num3 = sc.next();
            if (num3.equals("1")){
            wantBucket.addWant(menu1,num2);
            }
        } else if (num.equals("2")) {
            menu2.setMenu(num2);
            String num3 = sc.next();
            if (num3.equals("1")){
                wantBucket.addWant(menu2,num2);
            }
        } else if (num.equals("3")) {
            menu3.setMenu(num2);
            String num3 = sc.next();
            if (num3.equals("1")){
                wantBucket.addWant(menu3,num2);
            }
        } else {
            System.out.println("숫자가 잘못 입력됫소");
            return true;
        }
        return true;
    }


    private void viewMenuAndCash() {
        int i = 1;
        for (Menu menu : menupan) {
            System.out.println(i + ". " + menu.name);
            i++;
        }
        System.out.println("4. 결제");
        System.out.println("5. 주문취소");
        System.out.println("0. 종료");
    }

    public void viewMenu() {
        int i = 1;
        for (Menu menu : menupan) {
            System.out.println(i + ". " + menu.name);
            i++;
        }
        System.out.println("0. 종료");
    }

    public void setMenu() {
        Collections.addAll(menupan, menu1, menu2, menu3);

        MenuItem a = new MenuItem("새우버거", 92, "게맛살,새우깡,마요네즈,근처에 있던잡초로 만든버거");
        MenuItem b = new MenuItem("치킨버거", 85, "옆집KFC에서 튀기고 남은 짜투리를 뭉쳐서 만든버거");
        MenuItem c = new MenuItem("삼촌손버거", 394, "삼촌이 한땀한땀 손으로 뭉쳐준 패티가 들어간 버거");
        Collections.addAll(menu1.whatType, a, b, c);

        MenuItem d = new MenuItem("콜라", 150, "뒷마당 장독대에 담가둔 간장");
        MenuItem e = new MenuItem("사이다", 90, "이게 진짜 사이다");
        MenuItem f = new MenuItem("진짜 사이다", 150, "스프라이트");
        Collections.addAll(menu2.whatType, d, e, f);

        MenuItem g = new MenuItem("감자튀김", 50.4, "잘튀긴 동그란 감자");
        MenuItem h = new MenuItem("치즈 스틱", 30.1, "치즈 없는 치즈스틱");
        MenuItem i = new MenuItem("훈제 닭다리", 89.9, "훈제한 닭다리");
        Collections.addAll(menu3.whatType, g, h, i);
    }

    public boolean isThisZero(String num) {
        if (num.equals("0")) {
            System.out.println("시스템 캇~!");
            return true;
        }
        return false;
    }
}

