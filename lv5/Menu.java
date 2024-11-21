package kiosk.lv5;

import kiosk.myexception.WrongNumberException;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<MenuItem> whatType = new ArrayList<>();
    String name;

    public Menu(String name) {
        this.name = name;
    }

    public void setMenu(String num)  {
         int i = Integer.parseInt(num);
            whatType.get(i-1).showMenu();
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
