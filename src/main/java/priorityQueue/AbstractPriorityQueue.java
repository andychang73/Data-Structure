package priorityQueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    protected static class PQEntry<K,V> implements Entry<K,V>{

        private K k;
        private V v;

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

    private final Comparator<K> comp;

    public AbstractPriorityQueue(Comparator<K> comp){
        this.comp = comp;
    }

    public AbstractPriorityQueue(){
        this(new DefaultComparator<>());
    }

    public int compare(Entry<K,V> a, Entry<K,V> b){
        return comp.compare(a.getKey(), b.getKey());
    }

    public boolean checkKey(K key){
        try{
            return comp.compare(key, key) == 0;
        }catch (ClassCastException e){
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
