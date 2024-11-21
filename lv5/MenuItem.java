package kiosk.lv5;

public class MenuItem {
    private String name;
    private double price;
    private String sulmung;

    public MenuItem(String name, double price, String sulmung) {
        this.name = name;
        this.price = price;
        this.sulmung = sulmung;
    }

    public void showMenu() {
        System.out.println(name + "||"+ " $"+price+" || "+sulmung);
    }

}
