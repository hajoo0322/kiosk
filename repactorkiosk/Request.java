package kiosk.repactorkiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Request {
    List<MenuItem> wantItems = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Menu menu2;

    public void showMenu() {
        menu2.showMenu();
    }

    public void addWant(Menu menu, int num) {//확인을 받앗을때 실행해주는역할
        wantItems.add(menu.whatType.get(num - 1));
        System.out.println(menu.whatType.get(num - 1).getName() + "추가 됐습니다");
    }

    public double showSelectMenu() { //결제를 안내하고 결제를 호출하기 위한 역할
        int i = 1;
        double sum = 0;
        for (MenuItem menuItem : wantItems) {
            System.out.print(i + ". ");
            menuItem.showItem();
            sum += menuItem.getPrice();
            i++;
        }
        System.out.println("$ " + sum);
        System.out.println("1. 결제 2.메뉴로 돌아가기");

        return sum;
    }

    public void areYouDelete() { // 주문을 취소하는 역할
        System.out.println("진짜 주문을 취소합니까? 1.취소하기 2.메뉴로 돌아가기");
        String num = scanner.next();
        if (num.equals("1")) {
            wantItems.clear();
            System.out.println("주문삭제 완료");
            System.out.println("메뉴로 돌아갑니다");
        } else if (num.equals("2")) {
            System.out.println("메뉴로 돌아갑니다");
        }
    }

    public boolean cashMode(int num, double sum) {
        if (num == 1) {
            Cash cash = new Cash();
            return cash.cashAll(sum);
        } else {
            System.out.println("메뉴로 돌아갑니다");
        }
        return true;
    }
}
