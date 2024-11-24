package kiosk.repactorkiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
    List<MenuItem> whatType = new ArrayList<>();
    List<MenuItem> wantItems = new ArrayList<>();
    String name;
    Scanner scanner = new Scanner(System.in);

    public Menu(String name) {
        this.name = name;
    }

    public void showMenu() { //메뉴리스트에서 선택한 메뉴의 아이템들을 보여주기위한역할
        AtomicInteger index = new AtomicInteger(1);
        whatType.stream().
                forEach(a -> {
                    System.out.print(index.getAndIncrement() + ". ");
                    a.showMenu();
                });
        System.out.println("0. 뒤로가기");
    }

    public void setMenu(int index) {  //선택한 항목이 맞는지 확인하는역할
        whatType.get(index - 1).showMenu();
        System.out.println("위 메뉴를 장바구니에 추가합니까?");
        System.out.println("1. 확인 2. 취소");
    }

    public void addWant(Menu menu, int num) {//위의 메서드에서 확인을 받앗을때 실행해주는역할
        wantItems.add(menu.whatType.get(num - 1));
        System.out.println(menu.whatType.get(num - 1).getName() + "추가 됐습니다");
    }

    public double showSelectMenu() { //결제를 안내하고 결제를 호출하기 위한 역할
        int i = 1;
        double sum = 0;
        for (MenuItem menuItem : wantItems) {
            System.out.print(i + ". ");
            menuItem.showMenu();
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
