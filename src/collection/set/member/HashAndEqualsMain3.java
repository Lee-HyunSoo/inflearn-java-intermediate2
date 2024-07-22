package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain3 {

    public static void main(String[] args) {
        // 중복 등록 안됨
        MyHashSetV2 set = new MyHashSetV2(10);
        Member m1 = new Member("A");
        Member m2 = new Member("A");

        System.out.println("m1.hashCode() = " + m1.hashCode()); // 96
        System.out.println("m2.hashCode() = " + m2.hashCode()); // 96
        System.out.println("m1.equals(m2) = " + m1.equals(m2)); // true

        set.add(m1);
        set.add(m2);
        // MyHashSetV2{buckets=[[], [], [], [], [], [], [Member{id='A'}], [], [], []], size=1, capacity=10}
        System.out.println(set);

        Member searchValue = new Member("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode()); // 96
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains); // true
    }
}
