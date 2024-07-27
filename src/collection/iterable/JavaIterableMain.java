package collection.iterable;

import java.util.*;

public class JavaIterableMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        printAll(list.iterator());
        foreach(list);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        printAll(set.iterator());
        foreach(set);
    }

    /**
     * for-each 를 돌리기 위해서는 Iterable 만 있으면 된다.
     * 때문에 파라미터를 List<>, Set<> 이 아니라 Iterable 로 해서
     * 여러 자료구조를 받아 for-each 를 돌릴 수 있다.
     */
    private static void foreach(Iterable<Integer> iter) {
        for (Integer i : iter) {
            System.out.println(i);
        }
    }

    private static void printAll(Iterator<Integer> iterator) {
        System.out.println("iterator.getClass() = " + iterator.getClass());
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
    }
}
