package generic.ex3;

public class AnimalHospitalV2<T> {

    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        // T의 타입을 메서드를 정의하는 시점에는 알 수 없다. -> Object 의 기능만 사용 가능하다.
        // 때문에 아래 코드들은 컴파일 오류가 난다.
//        System.out.println("동물 이름: " + animal.getName());
//        System.out.println("동물 크기: " + animal.getSize());
//        animal.sound();

        animal.toString();
        animal.equals(null);
    }

    public T bigger(T target) {
        // 컴파일 오류 -> T의 타입을 모르기 때문에 메서드를 정의하는 시점에는 getSize() 같은 메서드를 모른다.
//        return animal.getSize() > target.getSize() ? animal : target;
        return null;
    }
}
