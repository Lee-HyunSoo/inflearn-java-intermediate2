package collection.utils;

import java.util.*;

public class EmptyListMain {

    public static void main(String[] args) {
        // 빈 가변 리스트 생성
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

        // 빈 불변 리스트 생성
        List<Integer> list3 = Collections.emptyList();// 자바 5
        List<Integer> list4 = List.of(); // 자바 9

        System.out.println("list3.getClass() = " + list3.getClass()); // class java.util.Collections$EmptyList
        System.out.println("list4.getClass() = " + list4.getClass()); // class java.util.ImmutableCollections$ListN

        Integer[] arr = {1, 2, 3};
        List<Integer> arr1 = Arrays.asList(arr); // 얘는 arr 를 내부에서 그대로 써버린다.
        List<Integer> arr2 = List.of(arr); // arr 를 하나씩 순회하며 리스트를 만든다.

        /**
         * Arrays.asList 는 arr 를 그대로 가져다가 리스트를 만들기 때문에,
         * arr1 의 내용을 바꾸면 기존의 arr 도 값이 바뀌어 버린다.
         * 반대로, arr 의 내용을 바꿔도 arr1 의 값도 바뀐다.
         *
         * 뭔가 엄청나게 큰 배열을 사용할 때는 성능 상 Arrays.asList 가 더 빠를 수 있다.
         * List.of() 는 한번 순회를 해서 새로운 리스트를 만들기 때문이다.
         */
        arr1.set(0, 100);
        arr[2] = 200;
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arr1 = " + arr1);
    }
}
