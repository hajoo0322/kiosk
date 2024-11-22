package kiosk.challenge;

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

    public void setMenu(String num)  {
         int i = Integer.parseInt(num);
            whatType.get(i-1).showMenu();
        System.out.println("위 메뉴를 장바구니에 추가합니까?");
        System.out.println("1. 확인 2. 취소");
            }

    public void showMenu(){
        AtomicInteger index = new AtomicInteger(1);
        whatType.stream().
                forEach(a -> {System.out.print(index.getAndIncrement()+". ");
                    a.showMenu();
                });
        System.out.println("0. 뒤로가기");
    }

    public boolean showSelectMenu() {
        int i = 1;
        double sum =0;
        for (MenuItem menuItem : wantItems) {
            System.out.print(i + ". ");
            menuItem.showMenu();
            sum += menuItem.getPrice();
            i++;
        }
        System.out.println("$ "+sum);
        System.out.println("1. 결제 2.메뉴로 돌아가기");
        String num = scanner.next();
        if (num.equals("1")) {
        Cash cash = new Cash();
        return cash.cashAll(sum);
        } else if (num.equals("2")) {
            System.out.println("메뉴로 돌아갑니다");
        }
        return true;
    }

    public void areYouDelete() {
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

    public void addWant(Menu menu, String num) {
        wantItems.add(menu.whatType.get(Integer.parseInt(num)-1));
        System.out.println(menu.whatType.get(Integer.parseInt(num)-1).getName()+"추가 됬습니다");
    }
}
