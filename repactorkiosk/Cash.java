package kiosk.repactorkiosk;

import java.util.Scanner;

public class Cash {
    public boolean cashAll(double sum) {
        System.out.println("직업 할인 쿠폰");
        System.out.println("1. 군인 \n"+"2. 스프링4기\n"+"3. 해당사항 없음");
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        if (num.equals("1")) {
            double saleSum = Sale.SOLIDER.saleCalculate(sum);
            System.out.println("군인할인 80% 결제금액은 $ "+saleSum+" 입니다");
            System.out.println("주문해주셔서 감사합니다 :)");
            return false;
        } else if (num.equals("2")) {
            double saleSum = Sale.SPRINGSTAGE4.saleCalculate(sum);
            System.out.println("스프링4기 특별할인 :) 200% 결제금액은 $ "+ saleSum+" 입니다.");
            System.out.println("주문해주셔서 감사합니다 :)");
            return false;
        } else if (num.equals("3")) {
            System.out.println("주문완료 금액은: $ "+sum+" 입니다.");
            System.out.println("주문해주셔서 감사합니다 :)");
            return false;
        } else {
            System.out.println("잘못된 입력입니다.");
        }
        return true;
    }
}
