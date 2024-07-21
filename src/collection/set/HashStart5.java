package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // 입력: 1, 2, 5, 8, 14, 99
        // 충돌할 확률이 낮기 때문에 LinkedList 사용, 충돌날 때만 add 하면 됨
        // ArrayList 는 미리 배열을 만들기 때문에 메모리 낭비 가능성
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];

        // [null, null, null, null, null, null, null, null, null, null]
        System.out.println("buckets = " + Arrays.toString(buckets));
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        // [[], [], [], [], [], [], [], [], [], []]
        System.out.println("buckets = " + Arrays.toString(buckets));

        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9); // 99 와 중복 된 hashIndex
        // [[], [1], [2], [], [14], [5], [], [], [8], [99, 9]]
        System.out.println("buckets = " + Arrays.toString(buckets));

        // 검색
        int searchValue = 9;
        boolean contains = contains(buckets, searchValue);
        System.out.println("bucket.contains(" + searchValue + ") = " + contains);
    }

    private static void add(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
        // 중복 체크, O(n)
        if (!bucket.contains(value)) {
            bucket.add(value);
        }
    }

    private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
        return bucket.contains(searchValue); // O(n)
    }

    private static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
