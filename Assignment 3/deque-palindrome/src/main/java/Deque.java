public interface Deque<T> {

    public void addFirst(T item);

    public void addLast(T item);

    public boolean isEmpty();

    public int size();

    public String toString();

    public T removeFirst();

    public T removeLast();

    public T get(int index);
}