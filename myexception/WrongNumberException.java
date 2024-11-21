package kiosk.myexception;

public class WrongNumberException extends Exception{
    public WrongNumberException(){
        super("잘못된 숫자를 입력했습니다. 다시 입력하시오");
    }
}
