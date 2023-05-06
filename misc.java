public interface ISimpleStack<E> {
 
    void push(E e);
    E pop();
    int size();
    boolean isEmpty();
}