package generic.ex4;

public class MethodMain1 {

    public static void main(String[] args) {
        Integer i = 10;
        // 반환값 Object -> 캐스팅 필요
        Integer integer1 = (Integer) GenericMethod.objMethod(i);

        // 타입 인자(Type Argument) 명시적 전달 -> 캐스팅 필요 x
        System.out.println("명시적 타입 인자 전달");
        Integer integer2 = GenericMethod.<Integer>genericMethod(i);

        // 상한 지정
        Integer integer3 = GenericMethod.<Integer>numberMethod(100);
        Double double1 = GenericMethod.<Double>numberMethod(20.0);
//        GenericMethod.<String>numberMethod("Hello"); // 컴파일 오류 Number의 자식만 입력 가능

        // 타입 추론, 타입 인자 생략
        System.out.println("타입 추론");
        Integer integer4 = GenericMethod.genericMethod(i);
        Integer integer5 = GenericMethod.numberMethod(i);
        Double double2 = GenericMethod.numberMethod(20.2);
    }
}
