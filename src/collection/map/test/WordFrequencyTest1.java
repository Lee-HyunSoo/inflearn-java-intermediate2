package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest1 {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        Map<String, Integer> map = new HashMap<>();

        String[] split = text.split(" ");
        for (String s : split) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
    }
}
