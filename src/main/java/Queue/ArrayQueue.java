package Queue;

import Queue.interfaces.Queue;

public class ArrayQueue<E> implements Queue<E> {

    private static final int CAPACITY = 16;
    private E[] data;
    private int f = 0;
    private int size = 0;

    public ArrayQueue(){
        this(CAPACITY);
    }

    public ArrayQueue(int capacity){
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
    public void enqueue(E e) {
        if(size == data.length){
            throw new IllegalStateException();
        }
        int avail = (f + size) % data.length;
        data[avail] = e;
        size++;
    }

    @Override
    public E first() {
        if(isEmpty()){
            return null;
        }
        return data[f];
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            return null;
        }
        E element = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return element;
    }
}
