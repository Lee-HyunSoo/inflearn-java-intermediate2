package generic.ex4;

import generic.animal.Animal;

public class ComplexBox<T extends Animal> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    // 이 경우 이 메서드의 T 는 제네릭 타입의 소속이어야 하나 제네릭 메서드의 소속이어야 하나? -> 제네릭 메서드가 우선순위
    public <T> T printAndReturn(T t) {
        System.out.println("animal.className: " + animal.getClass());
        System.out.println("t.className: " + t.getClass().getName());
//        t.getName(); // 호출 불가, 메서드는 <T> 타입이지 <T extends Animal> 타입이 아니기 때문
        return t;
    }
}
