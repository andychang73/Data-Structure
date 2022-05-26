package priorityQueue.impl;

import lombok.Data;
import priorityQueue.AdaptablePriorityQueue;
import priorityQueue.Entry;

public class HeapAdaptablePriorityQueue<K,V> extends HeapPriorityQueue<K,V> implements AdaptablePriorityQueue<K,V> {

    @Data
    protected static class AdaptablePQEntry<K,V> extends PQEntry<K,V>{
        private int index;

        public AdaptablePQEntry(K key, V value, int index){
            super(key,value);
            this.index = index;
        }
    }

    protected AdaptablePQEntry<K,V> validate(Entry<K,V> entry) throws IllegalArgumentException{
        if(! (entry instanceof AdaptablePQEntry)){
            throw new IllegalArgumentException("Invalid entry");
        }
        AdaptablePQEntry<K,V> locator = (AdaptablePQEntry<K,V>) entry;
        int i = locator.getIndex();
        if(i >= size() || heap.get(i) != locator){
            throw new IllegalArgumentException("Invalid entry");
        }
        return locator;
    }

    protected void bubble(int i){
        if(i > 0 && compare(heap.get(i), heap.get(parent(i))) < 0){
            upHeap(i);
        }else{
            downHeap(i);
        }
    }

    @Override
    protected void swap(int i, int k) {
        super.swap(i, k);
        ((AdaptablePQEntry<K,V>) heap.get(i)).setIndex(i);
        ((AdaptablePQEntry<K,V>) heap.get(k)).setIndex(k);
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newest = new AdaptablePQEntry<>(key, value, heap.size());
        heap.add(newest);
        upHeap(heap.size() - 1);
        return newest;
    }

    @Override
    public void remove(Entry<K, V> entry) {
        AdaptablePQEntry<K,V> locator = validate(entry);
        int i = locator.getIndex();
        if(i == heap.size() - 1){
            heap.remove(heap.size() - 1);
        }else{
            swap(i, heap.size() - 1);
            heap.remove(heap.size() - 1);
            bubble(i);
        }
    }

    @Override
    public void replaceKey(Entry<K, V> entry, K key) {
        AdaptablePQEntry<K,V> locator = validate(entry);
        checkKey(key);
        locator.setK(key);
        bubble(locator.getIndex());
    }

    @Override
    public void replaceValue(Entry<K, V> entry, V value) {
        AdaptablePQEntry<K,V> locator = validate(entry);
        locator.setV(value);
    }
}
