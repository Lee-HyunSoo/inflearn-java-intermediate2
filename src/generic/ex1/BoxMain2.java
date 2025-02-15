package generic.ex1;

public class BoxMain2 {

    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.setValue(10);
        Integer integer = (Integer) integerBox.getValue(); // Object -> Integer 캐스팅
        System.out.println("integer = " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.setValue("hello");
        String str = (String) stringBox.getValue(); // Object -> String 캐스팅
        System.out.println("str = " + str);

        // 잘못 된 타입의 인수 전달 시 (integerBox 인데 Object 타입이라 문자도 넣을 수 있음)
        integerBox.setValue("문자100");
        Integer result = (Integer) integerBox.getValue(); // String -> Integer 캐스팅 예외 (ClassCastException)
        System.out.println("result = " + result);
    }
}
