package kiosk.repactorkiosk;

import kiosk.myexception.WrongNumberException;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Kiosk {
    List<Menu> menuPan;
    Scanner sc = new Scanner(System.in);
    Request wantBucket = new Request();
    int menuPanIndex;

    public Kiosk(List<Menu> menupan) { //생성자로 메뉴판 주입당하기
        this.menuPan = menupan;
    }

    public boolean startKiosk() { // kiosk의 흐름을 담당하는메서드
        viewMenuAndCash();

        String num = sc.next();
        int number1 = isNumber(num , 1);
        if (number1 == 0) {
            System.out.println("시스템 끝~!");
            return false;
        } else if (number1 == -1) {
            return true;
        }

        if (!wantBucket.wantItems.isEmpty()) {
            if (number1 == menuPan.size()+1) {
                double sum = wantBucket.showSelectMenu();
                String num4 = sc.next();
                int number4 = isNumber(num4, 3);
                return wantBucket.cashMode(number4,sum);
            } else if (number1 == menuPan.size()+2) {
                wantBucket.areYouDelete();
                return true;
            }
        }

        menuPan.get(number1-1).showMenu();
        String num2 = sc.next();
        int number2 = isNumber(num2 , 2);

            if (number2 == 0) {
                System.out.println("뒤로갑니다");
                return true;
            } else if (number2 == -1) {
                return true;
            }
        menuPan.get(number1-1).setMenu(number2);
            String num3 = sc.next();
        int number3 = isNumber(num3, 3);
        if (number3 == 1) {
            wantBucket.addWant(menuPan.get(number1-1), number2);
        } else if(number3 ==0) {
            System.out.println("뒤로간다.");
            return true;
        } else if (number3 == -1) {
            return true;
        }
        return true;
    }

    private void viewMenuAndCash() { //장바구니가 존재할때 메뉴와결제항목을 보여주는 담당

        AtomicInteger index = new AtomicInteger(1);
        menuPan.stream().
                forEach(a -> System.out.println(index.getAndIncrement()+". "+a.name));
        if (!wantBucket.wantItems.isEmpty()) {
            System.out.println((menuPan.size()+1) + ". 결제");
            System.out.println((menuPan.size()+2) + ". 주문취소" );
        }
        System.out.println("0. 종료");
    }

    public int isNumber(String number, int index) {
        try {
            int i = Integer.parseInt(number); // 숫자로 변환 시도
            // 추가 조건 검증
            if (index == 1) {
                menuPanIndex=i;
                if (wantBucket.wantItems.isEmpty() && (i < 0 || i > menuPan.size())) {
                    throw new WrongNumberException();
                } else if ( i > menuPan.size()+2) {
                    throw new WrongNumberException();
                }
                return i;
            } else if (index == 2 && (i < 0 || i > menuPan.get(menuPanIndex - 1).whatType.size())) {
                throw new WrongNumberException();
            } else if (index == 3 && (i < 0 || i > 2)) {
                throw new WrongNumberException();
            }
            return i; // 유효한 값 반환
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력 숫자를 입력하시오");
            return -1;
        } catch (WrongNumberException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}

