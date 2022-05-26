package Deque;

public class ArrayDeque<E> implements Deque<E> {

    private static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;
    private int f = 0;
    private int l = 0;

    public ArrayDeque(){
        this(CAPACITY);
    }

    public ArrayDeque(int capacity){
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
    public E first() {
        if(isEmpty()){
            return null;
        }
        return data[f];
    }

    @Override
    public E last() {
        if(isEmpty()){
            return null;
        }
        return data[l];
    }

    @Override
    public void addFirst(E e) {
        if(size == data.length){
            throw new IllegalStateException();
        }
        if(!isEmpty()){
            f = (f - 1 + data.length) % data.length;
        }
        data[f] = e;
        size++;
    }

    @Override
    public void addLast(E e) {
        if(size == data.length){
            throw new IllegalStateException();
        }
        if(!isEmpty()){
            l = (l + 1) % data.length;
        }
        data[l] = e;
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        E element = data[f];
        data[f] = null;
        size--;
        f = (f + 1) % data.length;
        return element;
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            return null;
        }
        E element = data[l];
        data[l] = null;
        size--;
        l = (l - 1 + data.length) % data.length;
        return element;
    }
}
