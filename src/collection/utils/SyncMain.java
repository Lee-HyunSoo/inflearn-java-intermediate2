package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // 쓰레드 1
        list.add(1);
        list.add(2);
        list.add(3);

        // 쓰레드 2
        list.remove(1);
        /**
         * 이렇게 어떤 애는 넣고 어떤 애는 지우는 것을 동시에 해버리면 데이터에 혼란이 생긴다.
         * 이를 방지하기 위해 멀티쓰레드 상황에 쓰는 리스트를 제공한다.
         */

        // class java.util.ArrayList
        System.out.println("list.getClass() = " + list.getClass());

        List<Integer> synchronizedList = Collections.synchronizedList(list);
        // class java.util.Collections$SynchronizedRandomAccessList
        System.out.println("synchronizedList.getClass() = " + synchronizedList.getClass());
    }
}
