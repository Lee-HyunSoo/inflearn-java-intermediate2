package collection.set;

import java.util.Arrays;

public class HashStart4 {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // 입력: 1, 2, 5, 8, 14, 99
        System.out.println("hashIndex(1) = " + hashIndex(1));
        System.out.println("hashIndex(2) = " + hashIndex(2));
        System.out.println("hashIndex(5) = " + hashIndex(5));
        System.out.println("hashIndex(8) = " + hashIndex(8));
        System.out.println("hashIndex(14) = " + hashIndex(14));
        System.out.println("hashIndex(99) = " + hashIndex(99));

        // [null, 1, 2, null, 14, 5, null, null, 8, 99]
        // index 를 HashIndex 로 사용, 값은 원래 값
        Integer[] inputArray = new Integer[CAPACITY];
        add(inputArray, 1);
        add(inputArray, 2);
        add(inputArray, 5);
        add(inputArray, 8);
        add(inputArray, 14);
        add(inputArray, 99);
        System.out.println("inputArray = " + Arrays.toString(inputArray));

        int searchValue = 14;
        Integer result = inputArray[hashIndex(searchValue)]; // O(1)
        System.out.println("result = " + result);
    }

    private static void add(Integer[] inputArray, int value) {
        inputArray[hashIndex(value)] = value;
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
