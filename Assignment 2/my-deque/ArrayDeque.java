public class ArrayDeque<T> {
    private T[] array;
    private int headIndex;
    private int tailIndex;
    private int size;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        headIndex = -1;
        tailIndex = 0;
        this.size = 0;
    }

    public ArrayDeque(ArrayDeque<T> other) {
        this.array = (T[]) new Object[other.array.length];
        this.headIndex = other.headIndex;
        this.tailIndex = other.tailIndex;
        this.size = other.size;
        for (int i = 0; i < other.array.length; i++) {
            this.array[i] = other.array[i];
        }
    }

    public void addFirst(T item) {
        if (size == array.length) { // if full
            T[] temp = (T[]) new Object[size * 2]; 

            for (int i = 0; i < array.length; i++) {
                temp[i+1] = array[i];
            }
            temp[0] = item;
            array = temp;
            size++;
            tailIndex = size - 1;
            headIndex = 0;
            return;
        }
        if (isEmpty()) { // if empty head and tail = first item
            headIndex = 0;
            tailIndex = 0;
            
        }
        else if (headIndex == 0) { // front already has something
            headIndex = array.length - 1; //  so addFirst goes to the end of the array
        }
        else {
            headIndex -= 1;
        }
        array[headIndex] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == array.length) {
            T[] temp = (T[]) new Object[size * 2]; 

            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            temp[array.length] = item;
            array = temp;
            size++;
            tailIndex = size - 1;
            headIndex = 0;
            return;
        }
        if (isEmpty()) {
            headIndex = 0;
            tailIndex = 0;
        }
        else if (tailIndex == array.length-1) {
            tailIndex = 0;
        }
        else {
            tailIndex += 1;
        } 
        array[tailIndex] = item;
        size++;
    }

    public boolean isEmpty() {
        return (headIndex == -1);
    }

    public int size() {
        return size;
    }

    public String toString() {
        String ans = "";
        for (int i = 0; i < array.length;i++) {
            ans += array[i] + " ";
        }
        return ans;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T ans = array[headIndex];
        array[headIndex] = null;
        if (headIndex == tailIndex) {
            headIndex = -1;
            tailIndex = -1;
        }
        else if (headIndex == array.length - 1) {
            headIndex = 0;
        }
        else {
            headIndex += 1;
        }
        size--;
        double usedCells = size;
        int j = 0;
        if ((usedCells/array.length < 0.25) && (array.length >= 16)) {
            T[] temp = (T[]) new Object[size];
            for (int i = 0; i < array.length; i++) {
                    if (array[i] != null) {
                        temp[j] = array[i];
                        j++;
                    }
                }
            array = temp;
            tailIndex = size;
            headIndex = 0;
        }
        return ans;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T ans = array[tailIndex];
        array[tailIndex] = null;
        if (headIndex == tailIndex) {
            headIndex = -1;
            tailIndex = -1;
        }
        else if (tailIndex == 0) {
            tailIndex = array.length - 1;
        }
        else {
            tailIndex -= 1;
        }       
        size--;
        double usedCells = size;
        int j = 0;
        if ((usedCells/array.length < 0.25) && (array.length >= 16)) {
            T[] temp = (T[]) new Object[size];
            for (int i = 0; i < array.length; i++) {
                    if (array[i] != null) {
                        temp[j] = array[i];
                        j++;
                    }
                }
            array = temp;
            tailIndex = size;
            headIndex = 0;
        }
        return ans;
    }

    public T get(int index) {
        return array[index];
    }

/*    public static void main(String[] args) {
        ArrayDeque<Integer> test = new ArrayDeque<Integer>();
        for (int i = 0; i <= 20; i++) {
            test.addFirst(i);
        }
        System.out.println(test.toString());
        System.out.println("Size: "+test.size());
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.removeLast();
        test.addLast(5);
        test.addFirst(2);
        test.addLast(69);
        ArrayDeque<Integer> copy = new ArrayDeque<Integer>(test); 
        test.removeLast();
        test.removeFirst();
        System.out.println("Test:" + test.toString());
        System.out.println("Size: "+test.size());
        System.out.println("Copy: "+copy.toString());
        System.out.println("Copy Size: "+copy.size());
    } */
}