package generic.ex4;

public class GenericMethod {

    public static Object objMethod(Object obj) {
        System.out.println("object print: " + obj);
        return obj;
    }

    // <T> : 이 메서드는 제네릭 메서드야.
    // T : 원하는 타입 매개변수
    public static <T> T genericMethod(T obj) {
        System.out.println("generic print: " + obj);
        return obj;
    }

    // 타입 매개변수에 상한 걸어 사용
    public static <T extends Number> T numberMethod(T t) {
        System.out.println("bound print: " + t);
        return t;
    }
}
