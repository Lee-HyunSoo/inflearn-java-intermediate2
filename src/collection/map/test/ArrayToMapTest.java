package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class ArrayToMapTest {

    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};
        Map<String, Integer> map = new HashMap<>();
        for (String[] str : productArr) {
            map.put(str[0], Integer.parseInt(str[1]));
        }

        for (String key : map.keySet()) {
            System.out.println("제품 = " + key + ", 가격 = " + map.get(key));
        }
    }
}
