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
    //만약 할인행사 같은걸 해야한다면 price에 getter를 추가하자
    public void showMenu() {
        System.out.println(name + "||"+ " $"+price+" || "+ discription);
    }
}
