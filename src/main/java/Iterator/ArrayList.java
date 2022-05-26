package Iterator;


import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{

    private class ArrayIterator implements Iterator<E>{

        private int index;
        private boolean removable = false;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public E next() throws NoSuchElementException {
            if(index >= size()){
                throw new NoSuchElementException();
            }
            removable = true;
            return data[index++];
        }

        @Override
        public void remove() throws IllegalStateException {
            if(!removable){
                throw new IllegalStateException();
            }
            ArrayList.this.remove(--index);
            removable = false;
        }
    }

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
    public Iterator<E> iterator() {
        return new ArrayIterator();
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
    public void add(E e) {
        add(size, e);
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index, size + 1);
        resize();
        for(int i = size -1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index, size);
        E value = data[index];
        data[index] = e;
        return value;
    }

    @Override
    public E remove(int index) {
        checkIndex(index, size);
        E value = data[index];
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        size--;
        return value;
    }

    private void resize(){
        if(size == data.length){
            E[] newArray = (E[])new Object[data.length * 2];
            for(int i = 0; i < data.length; i++){
                newArray[i] = data[i];
            }
            data = newArray;
        }
    }

    private void checkIndex(int index, int n){
        if(index < 0 || index >= n){
            throw new IndexOutOfBoundsException();
        }
    }
}
