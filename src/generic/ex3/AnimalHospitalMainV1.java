package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV1 {

    public static void main(String[] args) {
        AnimalHospitalV1 animalHospital = new AnimalHospitalV1();

        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("야옹이", 200);

        // 개 병원
        animalHospital.set(dog);
        animalHospital.checkup();

        // 고양이 병원
        animalHospital.set(cat);
        animalHospital.checkup();

        // 문제1 : 개 병원에 고양이 전달
        animalHospital.set(cat); // 매개변수 체크 실패 : 컴파일 오류가 발생하지 않음

        // 문제2 : 개 타입 반환
        animalHospital.set(dog);
        Dog biggerDog = (Dog) animalHospital.bigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog);
    }
}
