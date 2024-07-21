package collection.link;

public class Node {

    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node n = this;
        sb.append("[");
        while (n != null) {
            sb.append(n.item);
            if (n.next != null) {
                sb.append("->");
            }
            n = n.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
