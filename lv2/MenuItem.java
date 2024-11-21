package kiosk.lv2;

import kiosk.foods.CheeseBuger;
import kiosk.foods.ChickenBuger;
import kiosk.foods.ShrimpBuger;

public class MenuItem {
    String name;
    double price;
    String sulmung;

    public MenuItem(String name, double price, String sulmung) {
        this.name = name;
        this.price = price;
        this.sulmung = sulmung;
    }

    public void showMenu() {
        System.out.println(name + "||"+ " $"+price+" "+sulmung);
    }
}
