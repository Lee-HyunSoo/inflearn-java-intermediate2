package collection.array;

import java.util.Arrays;

public class MyArrayListV4<E> {

    /**
     * 리스트(MyArrayListV1)를 생성할 때 사용하는 기본 배열의 크기
     * 배열의 크기를 다르게 만들고 싶으면 MyArrayListV1(int initialCapacity) 생성자를 사용하면 된다.
     */
    private static final int DEFAULT_CAPACITY = 5;

    /**
     * 다양한 타입의 데이터를 보관하기 위해 Object 배열을 사용한다.
     */
    private Object[] elementData;

    /**
     * 리스트의 크기는 size 를 사용한다. 리스트를 표현하기 위해 내부에서 배열을 사용할 뿐이다.
     * 배열의 크기를 뜻하는 capacity 와 다르다는 점에 주의하자.
     * 예를 들어서 배열의 크기가 5 인데, 입력된 데이터가 하나도 없으면 size 는 0 이 된다.
     */
    private int size = 0;

    public MyArrayListV4() {
        // 생성자에는 E를 쓸 수 없다. -> new E[] 불가능
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV4(int initialCapacity) {
        // 생성자에는 E를 쓸 수 없다. -> new E[] 불가능
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    /**
     * 리스트에 데이터를 추가한다. 데이터를 추가하면 size 가 하나 증가한다.
     */
    public void add(E o) {
        // 코드 추가
        if (size == elementData.length) {
            grow();
        }
        elementData[size++] = o;
    }

    /**
     * add() 추가, 메서드 오버로딩
     */
    public void add(int index, E o) {
        if (size == elementData.length) {
            grow();
        }
        shiftRightFrom(index);
        elementData[index] = o;
        size++;
    }

    // 코드 추가
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    // 코드 추가, 요소의 마지막부터 index 까지 오른쪽으로 밀기
    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    /**
     * 인덱스에 있는 항목을 조회한다.
     */
    @SuppressWarnings("unchecked") // 경고를 무시하겠다.
    public E get(int index) {
        return (E) elementData[index];
    }

    /**
     *  인덱스에 있는 항목을 변경한다.
     */
    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    // 코드 추가
    public E remove(int index) {
        E oldValue = get(index);
        shiftLeftFrom(index);
        size--;
        elementData[size] = null;
        return oldValue;
    }

    // 코드 추가, 요소의 index 부터 마지막까지 왼쪽으로 밀기
    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    /**
     * 검색 기능이다. 리스트를 순차 탐색해서 인수와 같은 데이터가 있는 인덱스의 위치를 반환한다.
     * 데이터가 없으면 -1 을 반환한다.
     */
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Arrays.copyOf(elementData, size) : size 크기의 배열을 새로 만든다.
     * 여기서는 toString() 출력 시 size 이후의 의미 없는 값을 출력하지 않기 위해 사용한다.
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                " size=" + size + ", capacity=" + elementData.length;
    }
}
