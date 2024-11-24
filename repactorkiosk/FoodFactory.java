package kiosk.repactorkiosk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodFactory {
    List<Menu> menuPan = new ArrayList<>();
    Menu menu1 = new Menu("햄버거");
    Menu menu2 = new Menu("마실거");
    Menu menu3 = new Menu("주전부리");

    public FoodFactory() {    // 정보를 객체에 담아두는 초기세팅을 담당하는메서드
        Collections.addAll(menuPan, menu1, menu2, menu3);

        MenuItem a = new MenuItem("새우버거", 92, "게맛살,새우깡,마요네즈,근처에 있던잡초로 만든버거");
        MenuItem b = new MenuItem("치킨버거", 85, "옆집KFC에서 튀기고 남은 짜투리를 뭉쳐서 만든버거");
        MenuItem c = new MenuItem("삼촌손버거", 394, "삼촌이 한땀한땀 손으로 뭉쳐준 패티가 들어간 버거");
        Collections.addAll(menu1.whatType, a, b, c);

        MenuItem d = new MenuItem("콜라", 150, "뒷마당 장독대에 담가둔 간장");
        MenuItem e = new MenuItem("사이다", 90, "이게 진짜 사이다");
        MenuItem f = new MenuItem("진짜 사이다", 150, "스프라이트");
        Collections.addAll(menu2.whatType, d, e, f);

        MenuItem g = new MenuItem("감자튀김", 50.4, "잘튀긴 동그란 감자");
        MenuItem h = new MenuItem("치즈 스틱", 30.1, "치즈 없는 치즈스틱");
        MenuItem i = new MenuItem("훈제 닭다리", 89.9, "훈제한 닭다리");
        Collections.addAll(menu3.whatType, g, h, i);
    }
}
