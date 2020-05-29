public class LinkedListDeque<T> {
    private class Node {
        T current;
        Node prev;
        Node next;

        Node(T i) {
            this.current = i;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedListDeque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public LinkedListDeque(LinkedListDeque<T> other) {
        Node ele = other.first;
        this.size = other.size();
        for (int i = 0; i < other.size();i++) {
            this.addLast(ele.current);
            ele = ele.next;
        }
        
    }

    public void addFirst(T item) {
        Node x = new Node(item);
        if (isEmpty()) {
            last = x;
        }
        else {
            first.prev = x;
            x.next = first;
        }
        first = x;
        size++;
    }

    public void addLast(T item) {
        Node x = new Node(item);
        if (isEmpty()) {
            first = x;
        }
        else {
            last.next = x;
            x.prev = last;
        }
        last = x;
        size++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String ans = "";
        Node temp = first;
        for (int i=0;i<size;i++) {
            ans += temp.current + " ";
            temp = temp.next;
        }
        return ans;
    }

    public T removeFirst() {
        if (first == null) {
            return null;
        }
        T temp = first.current;
        if (first.next == null) {
            last = null;
        }
        else {
            first.next.prev = null;
        }
        first = first.next;
        size--;
        return temp;
    }

    public T removeLast() {
        if (last == null) {
            return null;
        }
        T temp = last.current;
        if (first.next == null) {
            first = null;
        }
        else {
            last.prev.next = null;
        }
        last = last.prev;
        size--;
        return temp;
    }

    public T get(int index) {
        Node temp = first;
        Node ans = first;
        if (index >= size || index < 0) {
            return null;
        }
        else {
            for (int i = 0; i <= index;i++) {
                ans = temp;
                temp = temp.next;
            }
            return ans.current;
        }
    }

/*    public static void main(String[] args) {
        LinkedListDeque<Integer> test = new LinkedListDeque<Integer>();
        test.addFirst(5);
        test.addLast(7);
        test.addFirst(2);
        test.addFirst(78);
        System.out.println(test.toString());
        System.out.println("Size: "+test.size());
        System.out.println(test.removeFirst());
        System.out.println("Size: "+test.size());
        System.out.println(test.removeLast());
        System.out.println("Size: "+test.size());
        System.out.println(test.removeFirst());
        System.out.println("Size: "+test.size());
        System.out.println(test.removeFirst());
        System.out.println(test.toString());
        System.out.println("Size: "+test.size());
    } */
}