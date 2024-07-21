package collection.list;

public class MyLinkedList<E> implements MyList<E> {

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> n = this;
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

    private Node<E> first;
    private int size = 0;

    /**
     * 마지막에 데이터를 추가한다.
     * 새로운 노드를 만들고, 마지막 노드를 찾아서 새로운 노드를 마지막에 연결한다.
     * 만약 노드가 하나도 없다면 새로운 노드를 만들고 `first` 에 연결한다.
     */
    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e);
        if (first == null) {
            first = node;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = node;
        }
        size++;
    }

    /**
     * node.next == null -> 다음 노드가 없다는 뜻
     * while 문을 통해 반복, next 가 null 인 노드 반환
     */
    private Node<E> getLastNode() {
        Node<E> n = first;
        while (n.next != null) {
            n = n.next;
        }
        return n;
    }

    // 추가 코드
    /**
     * index == 0 -> newNode.next 를 first 로, first 를 newNode 로 갱신
     * index != 0 -> index 의 이전 노드를 구함, newNode.next = prev.next, prev.next = newNode 로 갱신
     */
    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    /**
     * 특정 위치에 있는 데이터를 찾아서 변경한다. 그리고 기존 값을 반환한다.
     * getNode(index) 를 통해 특정 위치에 있는 노드를 찾고, 단순히 그 노드에 있는 item 데이터를 변경한다.
     */
    @Override
    public E set(int index, E element) {
        Node<E> n = getNode(index);
        E oldValue = n.item;
        n.item = element;
        return oldValue;
    }

    // 추가 코드
    /**
     * index == 0 -> 시작 위치를 removeNode 의 다음 것으로 변경
     * index != 0 -> index 의 이전 노드를 구함 (prev), prev 의 다음 칸을 지워야할 노드의 다음 칸으로 변경
     * 지워야할 노드 초기화 -> GC 의 대상이 됨, 전체 크기 -1
     */
    @Override
    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E removeItem = removeNode.item;
        if (index == 0) {
            first = removeNode.next;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = removeNode.next;
        }
        removeNode.next = null;
        removeNode.item = null;
        size--;
        return removeItem;
    }

    /**
     * 특정 위치에 있는 데이터를 반환한다.
     * getNode(index) 를 통해 특정 위치에 있는 노드를 찾고, 해당 노드에 있는 값을 반환한다.
     */
    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    /**
     * 처음부터 index 까지 노드를 순회하여 index 번째의 노드를 반환
     */
    private Node<E> getNode(int index) {
        Node<E> n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    /**
     * 데이터를 검색하고, 검색된 위치를 반환한다.
     * 모든 노드를 순회하면서 equals() 를 사용해서 같은 데이터가 있는지 찾는다.
     */
    @Override
    public int indexOf(E e) {
        int index = 0;
        for (Node<E> n = first; n != null; n = n.next) {
            if (e.equals(n.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV2{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}
