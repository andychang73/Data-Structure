package List;

public class ArrayList<E> implements List<E>{

    private static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList(){
        this(CAPACITY);
    }

    public ArrayList(int capacity){
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index, size);
        return data[index];
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index, size);
        E temp = data[index];
        data[index] = e;
        return temp;
    }

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index, size + 1);
        if(size == data.length){
            resize();
        }
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index, size);
        E temp = data[index];
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }

    private void resize(){
        E[] newArray = (E[]) new Object[data.length*2];
        for(int i = 0 ; i < data.length; i++){
            newArray[i] = data[i];
        }
        data = newArray;
    }

    private void checkIndex(int index, int n){
        if(index < 0 || index >= n){
            throw new IndexOutOfBoundsException();
        }
    }
}
