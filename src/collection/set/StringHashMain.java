package collection.set;

public class StringHashMain {

    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // char
        char charA = 'A';
        char charB = 'B';
        System.out.println("charA = " + (int) charA); // 65
        System.out.println("charB = " + (int) charB); // 66

        // hashCode
        System.out.println("hashCode = " + hashCode("A")); // 65
        System.out.println("hashCode = " + hashCode("B")); // 66
        System.out.println("hashCode = " + hashCode("AB")); // 131

        // hashIndex
        System.out.println("hashIndex = " + hashIndex(hashCode("A"))); // 5
        System.out.println("hashIndex = " + hashIndex(hashCode("B"))); // 6
        System.out.println("hashIndex = " + hashIndex(hashCode("AB"))); // 1
    }

    static int hashCode(String str) {
        char[] chars = str.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += c;
        }
        return sum;
    }

    static int hashIndex(int value) {
        return value % CAPACITY;
    }
}
