package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain1 {

    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이", 100));

        WildcardEx.printGenericV1(dogBox); // T = Animal{name='멍멍이', size=100}
        WildcardEx.printWildcardV1(dogBox); // ? = Animal{name='멍멍이', size=100}

        WildcardEx.printGenericV2(dogBox); // 이름 = 멍멍이
        WildcardEx.printWildcardV2(dogBox); // 이름 = 멍멍이

        Dog dog = WildcardEx.printAndReturnGeneric(dogBox); // 이름 = 멍멍이
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox); // 이름 = 멍멍이
    }
}
