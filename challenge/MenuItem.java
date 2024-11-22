package kiosk.challenge;

public class MenuItem{
   private String name;
   private double price;
   private String discription;

    public MenuItem(String name, double price, String discription) {
        this.name = name;
        this.price = price;
        this.discription = discription;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void showMenu() {
        System.out.println(name + "||"+ " $"+price+" || "+ discription);
    }
}
