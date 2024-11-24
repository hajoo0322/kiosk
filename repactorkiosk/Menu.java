package kiosk.repactorkiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Menu {
    List<MenuItem> whatType = new ArrayList<>();
    String name;

    public Menu(String name) {
        this.name = name;
    }

    public void showMenu() { //메뉴리스트에서 선택한 메뉴의 아이템들을 보여주기위한역할
        AtomicInteger index = new AtomicInteger(1);
        whatType.stream().
                forEach(a -> {
                    System.out.print(index.getAndIncrement() + ". ");
                    a.showItem();
                });
        System.out.println("0. 뒤로가기");
    }

    public void setMenu(int index) {  //선택한 항목이 맞는지 확인하는역할
        whatType.get(index - 1).showItem();
        System.out.println("위 메뉴를 장바구니에 추가합니까?");
        System.out.println("1. 확인 2. 취소");
    }
}
