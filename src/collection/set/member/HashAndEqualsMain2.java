package collection.set.member;

import collection.set.MyHashSetV2;

public class HashAndEqualsMain2 {

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        MemberOnlyHash m1 = new MemberOnlyHash("A");
        MemberOnlyHash m2 = new MemberOnlyHash("A");

        System.out.println("m1.hashCode() = " + m1.hashCode()); // 96
        System.out.println("m2.hashCode() = " + m2.hashCode()); // 96
        System.out.println("m1.equals(m2) = " + m1.equals(m2)); // false

        set.add(m1);
        set.add(m2);
        // MyHashSetV2{buckets=[[], [], [], [], [], [], [MemberOnlyHash{id='A'}, MemberOnlyHash{id='A'}], [], [], []], size=2, capacity=10}
        System.out.println(set);

        // 검색 실패
        MemberOnlyHash searchValue = new MemberOnlyHash("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode()); // 96
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains); // false
    }
}
