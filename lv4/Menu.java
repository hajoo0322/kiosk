package kiosk.lv4;

import kiosk.myexception.WrongNumberException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Menu {
    List<MenuItem> whatType = new ArrayList<>();

    public boolean setMenu(String num) throws WrongNumberException {
        int i=0;
        try {
            i = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            System.out.println("문자를 입력하지 마시오");
            return false;
        }

        if (i > 3) {
            throw new WrongNumberException();
        } else {
            whatType.get(i-1).showMenu();
        }
        return true;
    }

    public void showMenu(){
        int i = 1;
        for (MenuItem menuItem : whatType) {
            System.out.print(i + ". ");
            menuItem.showMenu();
            i++;
        }
    }
}
