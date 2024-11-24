package kiosk.repactorkiosk;

import kiosk.myexception.WrongNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Kiosk {
    List<Menu> menupan = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Menu menu1 = new Menu("햄버거");
    Menu menu2 = new Menu("마실거");
    Menu menu3 = new Menu("주전부리");
    Menu wantBucket = new Menu("장바구니");

    public boolean startKiosk() { // kiosk의 흐름을 담당하는메서드
        if (wantBucket.wantItems.isEmpty()) {
            viewMenu();
        } else {
            viewMenuAndCash();
        }

        String num = sc.next();
        int number1 = isNumber(num , 1);
        if (isThisZero(number1)) {
            System.out.println("시스템 끝~!");
            return false;
        }

        if (!wantBucket.wantItems.isEmpty()) {
            if (number1 == 4) {
                return wantBucket.showSelectMenu();
            } else if (number1 == 5) {
                wantBucket.areYouDelete();
                return true;
            }
        }

        menupan.get(number1-1).showMenu();
        String num2 = sc.next();
        int number2 = isNumber(num2 , 2);

            if (isThisZero(number2)) {
                System.out.println("뒤로갑니다");
                return true;
            }
        menupan.get(number1-1).setMenu(number2);
            String num3 = sc.next();
        int number3 = isNumber(num3, 3);
        if (number3 == 1) {
            wantBucket.addWant(menupan.get(number1-1), number2);
        } else {
            System.out.println("뒤로간다.");
            return true;
        }
        return true;
    }

    public void setMenu() {    // 정보를 객체에 담아두는 초기세팅을 담당하는메서드
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

    public void viewMenu() {  // 메뉴를 보여주기위한 담당
        AtomicInteger index = new AtomicInteger(1);
        menupan.stream().
                forEach(a -> System.out.println(index.getAndIncrement()+". "+a.name));
        System.out.println("0. 종료");
    }

    private void viewMenuAndCash() { //장바구니가 존재할때 메뉴와결제항목을 보여주는 담당

        AtomicInteger index = new AtomicInteger(1);
        menupan.stream().
                forEach(a -> System.out.println(index.getAndIncrement()+". "+a.name));

        System.out.println((menupan.size()+1) + ". 결제");
        System.out.println((menupan.size()+2) + ". 주문취소" );
        System.out.println("0. 종료");
    }

    public boolean isThisZero(int num) {  //프로그램의 종료를 담당하는 메서드
        if (num == 0) {
            return true;
        }
        return false;
    }

    public int isNumber(String number, int index) {
        int i = 0;
        try {
            i = Integer.parseInt(number);
            if (index == 1) {
                if (wantBucket.wantItems.isEmpty()) {
                    if (i > menupan.size()) {
                        throw new WrongNumberException();
                    }
                } else {
                    if (i > menupan.size()+2) {
                        throw new WrongNumberException();
                    }
                }
            } else if (index == 2) {
                if (i > menupan.get(i - 1).whatType.size()) {
                    throw new WrongNumberException();
                }
            } else {
                if (!(i == 1 || i == 2)) {
                    throw new WrongNumberException();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return i ;
    }
}

