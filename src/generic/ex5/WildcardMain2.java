package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

public class WildcardMain2 {

    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        // Animal 포함 상위 타입 전달 가능
        writeBox(objBox);
        writeBox(animalBox);
        // 하한이 Animal 이기 때문에 Animal 보다 아래에 있는 Dog, Cat은 넣을 수 없다.
//        writeBox(dogBox);
//        writeBox(catBox);

        Animal animal = animalBox.get();
        System.out.println("animal = " + animal);
    }

    // ? 가 Animal 이상이어야 한다.
    static void writeBox(Box<? super Animal> box) {
        box.set(new Dog("멍멍이", 100));
    }
}
