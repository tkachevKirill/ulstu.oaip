public class Main<E> implements ISimpleStack<E>{
    private Object[] array;
    private final int DEFAULT_INITIAL_CAPACITY = 10;
    private int currentCapacity;
    private int size;
 
    public Main() {
        this.array = new Object[0];
        this.size = -1;
    }
 
    @Override
    public void push(E e) {
        if(currentCapacity == 0){
            this.array = new Object[DEFAULT_INITIAL_CAPACITY];
            currentCapacity = array.length;
        }
 
        if(currentCapacity - size < 5){
            ensureIncreaseCapacity();
        }
        array[++size] = e;
 
    }
 
    @Override
    public E pop() {
        if(size < 0){
            throw new NullPointerException();
        }
 
        return (E) array[size--];
    }
 
    @Override
    public int size() {
        return size + 1;
    }
 
    @Override
    public boolean isEmpty() {
        return size < 0;
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i] + ",");
        }
 
        return sb.toString();
    }
 
    private void ensureIncreaseCapacity(){
        array = Arrays.copyOf(array, currentCapacity + 5);
        currentCapacity = array.length;
        System.out.println(currentCapacity);
    }
 
    private void ensureDecreaseCapacity(){
        array = Arrays.copyOfRange(array, 0, size);
        currentCapacity = array.length;
    }
}
