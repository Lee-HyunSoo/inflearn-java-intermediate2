package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {

    public static void main(String[] args) {
        // Object 의 기본 hashCode 는 객체의 참조값을 기반으로 생성
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("obj1.hashCode() = " + obj1.hashCode()); // 168423058
        System.out.println("obj2.hashCode() = " + obj2.hashCode()); // 1325547227

        // 각 클래스마다 hashCode 를 이미 오버라이딩 해두었다.
        Integer i = 10;
        String strA = "A";
        String strAB = "AB";

        System.out.println("i.hashCode() = " + i.hashCode()); // 10
        System.out.println("strA.hashCode() = " + strA.hashCode()); // 65
        System.out.println("strAB.hashCode() = " + strAB.hashCode()); // 2081

        // hashCode 는 마이너스 값이 들어올 수 있다.
        System.out.println("-1.hashCode() = " + Integer.valueOf(-1).hashCode()); // -1

        // 둘은 같을까? 인스턴스는 다르지만 equals 는 같다.
        Member member1 = new Member("idA");
        Member member2 = new Member("idA");

        // equals, hashCode 를 오버라이딩 하지 않은 경우와 한 경우를 비교
        System.out.println("(member1 == member2) = " + (member1 == member2)); // false
        System.out.println("(member1 equals member2) = " + (member1.equals(member2))); // true
        System.out.println("member1.hashCode() = " + member1.hashCode()); // 104101, 2061475679(오버라이딩 x)
        System.out.println("member2.hashCode() = " + member2.hashCode()); // 104101, 140435067(오버라이딩 x)
    }
}
