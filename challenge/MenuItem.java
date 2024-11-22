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

    public double getPrice() { //결제를 위해 저장된 가격을 보여주기위한역할
        return price;
    }

    public String getName() { //항목에 추가해줄때 이름을 보여줌으로써 확인시켜주는 역할
        return name;
    }

    public void showMenu() {
        System.out.println(name + "||"+ " $"+price+" || "+ discription);
    }
}
