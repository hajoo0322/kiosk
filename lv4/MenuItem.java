package kiosk.lv4;

public class MenuItem{
    String name;
    double price;
    String discription;

    public MenuItem(String name, double price, String discription) {
        this.name = name;
        this.price = price;
        this.discription = discription;
    }

    public void showMenu() {
        System.out.println(name + "||"+ " $"+price+" || "+ discription);
    }
}
