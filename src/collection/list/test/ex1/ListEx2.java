package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> arrayList = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            int input = scan.nextInt();
            if (input == 0) {
                break;
            }
            arrayList.add(input);
        }
        System.out.println("출력");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
            if (i < arrayList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
