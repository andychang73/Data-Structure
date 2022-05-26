package priorityQueue.impl;

import Iterator.ArrayList;
import priorityQueue.AbstractPriorityQueue;
import priorityQueue.DefaultComparator;
import priorityQueue.Entry;

import java.util.Comparator;

public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    protected final ArrayList<Entry<K,V>> heap = new ArrayList<Entry<K,V>>();

    public HeapPriorityQueue(Comparator<K> comp){
        super(comp);
    }

    public HeapPriorityQueue(){
        super(new DefaultComparator<>());
    }

    public HeapPriorityQueue(K[] keys, V[] values){
        for(int i = 0; i < Math.min(keys.length, values.length); i++){
            heap.add(new PQEntry<>(keys[i], values[i]));
        }
        heapify();
    }

    private void heapify() {
        int startIndex = heap.size() - 1;
        for(int i = startIndex; i >= 0; i--){
            downHeap(i);
        }
    }

    protected int parent(int i){
        return (i - 1) / 2;
    }

    protected int left(int i){
        return i * 2 + 1;
    }

    protected int right(int i){
        return i * 2 + 2;
    }

    protected boolean hasLeft(int i){
        return left(i) < size();
    }

    protected boolean hasRight(int i){
        return right(i) < size();
    }

    protected void swap(int i, int k){
        Entry<K,V> temp = heap.get(i);
        heap.set(i, heap.get(k));
        heap.set(k, temp);
    }

    protected void upHeap(int i){
        while(i > 0){
            int p = parent(i);
            if(compare(heap.get(i), heap.get(p)) >= 0){
                break;
            }
            swap(i, p);
            i = p;
        }
    }

    protected void downHeap(int i){
        while(hasLeft(i)){
            int smallest = left(i);
            if(hasRight(i)){
                int rightIndex = right(i);
                if(compare(heap.get(rightIndex), heap.get(smallest)) < 0){
                    smallest = rightIndex;
                }
            }
            if(compare(heap.get(i), heap.get(smallest)) <= 0){
                break;
            }
            swap(i, smallest);
            i = smallest;
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newest = new PQEntry<>(key,value);
        heap.add(newest);
        upHeap(heap.size()-1);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if(isEmpty()){
            return null;
        }
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        if(isEmpty()){
            return null;
        }
        Entry<K,V> temp = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return temp;
    }
}
