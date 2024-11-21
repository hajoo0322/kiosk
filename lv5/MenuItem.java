package kiosk.lv5;

public class MenuItem{
   private String name;
   private double price;
   private String discription;

    public MenuItem(String name, double price, String discription) {
        this.name = name;
        this.price = price;
        this.discription = discription;
    }

    public void showMenu() {
        System.out.println(name + "||"+ " $"+price+" || "+ discription);
    }
}
