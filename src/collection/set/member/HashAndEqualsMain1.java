package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain1 {

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        MemberNoHashNoEq m1 = new MemberNoHashNoEq("A");
        MemberNoHashNoEq m2 = new MemberNoHashNoEq("A");

        System.out.println("m1.hashCode() = " + m1.hashCode()); // 258952499
        System.out.println("m2.hashCode() = " + m2.hashCode()); // 1450495309
        System.out.println("m1.equals(m2) = " + m1.equals(m2)); // false

        set.add(m1);
        set.add(m2);
        // MyHashSetV2{buckets=[[], [], [], [], [], [], [], [], [], [MemberNoHashNoEq{id='A'}, MemberNoHashNoEq{id='A'}]], size=2, capacity=10}
        System.out.println(set);

        // 검색 실패
        MemberNoHashNoEq searchValue = new MemberNoHashNoEq("A"); // 2003749087
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains); // false
    }
}
