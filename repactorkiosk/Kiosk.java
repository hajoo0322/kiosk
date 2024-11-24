package kiosk.repactorkiosk;

import kiosk.myexception.WrongNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Kiosk {
    List<Menu> menupan;
    Scanner sc = new Scanner(System.in);
    Menu wantBucket = new Menu("장바구니");

    public Kiosk(List<Menu> menupan) { //생성자로 메뉴판 주입당하기
        this.menupan = menupan;
    }

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
                double sum = wantBucket.showSelectMenu();
                String num4 = sc.next();
                int number4 = isNumber(num4, 3);
                return wantBucket.cashMode(number4,sum);
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

