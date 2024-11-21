package kiosk.lv4;

import kiosk.myexception.WrongNumberException;

public class Menu {

    public void selectMenu(String num) throws WrongNumberException {

        if (num.equals("1")) {
            new MenuItem("새우버거",92,"게맛살,새우깡,마요네즈,근처에 있던잡초로 만든버거").showMenu();
        } else if (num.equals("2")) {
            new MenuItem("치킨버거", 85, "옆집KFC에서 튀기고 남은 짜투리를 뭉쳐서 만든버거").showMenu();
        } else if (num.equals("3")) {
            new MenuItem("삼촌손버거", 394, "삼촌이 한땀한땀 손으로 뭉쳐준 패티가 들어간 버거").showMenu();
        } else {
            throw new WrongNumberException();
        }
    }
}
