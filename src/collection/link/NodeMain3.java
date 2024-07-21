package collection.link;

public class NodeMain3 {

    public static void main(String[] args) {
        // 노드 생성하고 연결하기: A -> B -> C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        System.out.println(first);

        // 모든 노드 탐색하기
        System.out.println("모든 노드 탐색하기");
        printAll(first);

        // 마지막 노드 조회하기
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        // 특정 index 의 노드 조회하기
        int index = 2;
        Node idxNode = getNode(first, index);
        System.out.println("idxNode = " + idxNode.item);

        // 데이터 추가하기
        System.out.println("데이터 추가하기");
        add(first, "D");
        System.out.println(first);
        add(first, "E");
        System.out.println(first);
        add(first, "F");
        System.out.println(first);
    }

    /**
     * 다음 노드가 없을 때 까지 반복해서 노드의 데이터를 출력한다.
     */
    private static void printAll(Node node) {
        Node n = node;
        while (n != null) {
            System.out.println(n.item);
            n = n.next;
        }
    }

    /**
     * Node.next 의 참조값이 null 이면 노드의 끝이다.
     * getLastNode() 는 노드를 순서대로 탐색하면서 Node.next 의 참조값이 null 인 노드를 찾아서 반환한다.
     * 여기서는 마지막에 있는 C 값을 가지고 있는 노드가 출력된다.
     */
    private static Node getLastNode(Node node) {
        Node n = node;
        while (n.next != null) {
            n = n.next;
        }
        return n;
    }

    /**
     * n = n.next 를 호출할 때 마다 n이 참조하는 노드의 위치가 순서대로 하나씩 증가한다.
     * index 의 수 만큼만 반복해서 이동하면 원하는 위치의 노드를 찾을 수 있다.
     */
    private static Node getNode(Node node, int index) {
        Node n = node;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    /**
     * 데이터를 추가할 때는 새로운 노드를 만들고, 마지막 노드에 새로 만든 노드를 연결하면 된다.
     * 순서대로 설명하면 먼저 마지막 노드를 찾고, 마지막 노드의 next 에 새로운 노드를 연결하면 된다.
     */
    private static void add(Node node, String s) {
        Node lastNode = getLastNode(node);
        lastNode.next = new Node(s);
    }
}
