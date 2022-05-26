package priorityQueue.impl;

import Iterator.Iterator;
import Iterator.LinkedPositionalList;
import Iterator.positionalList.Position;
import priorityQueue.AbstractPriorityQueue;
import priorityQueue.Entry;

import java.util.Comparator;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    private final LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<Entry<K,V>>();

    @Override
    public int size() {
        return list.size();
    }

    public UnsortedPriorityQueue(){
        super();
    }

    public UnsortedPriorityQueue(Comparator<K> comp){
        super(comp);
    }

    private Position<Entry<K,V>> findMin(){
        Position<Entry<K,V>> smallest = list.last();
        Iterator<Position<Entry<K,V>>> iterator = list.positions().iterator();
        while(iterator.hasNext()){
            if(compare(iterator.next().getElement(), smallest.getElement()) < 0){
                smallest = iterator.next();
            }
        }
        return smallest;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newest = new PQEntry<>(key, value);
        list.addLast(newest);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if(isEmpty()){
            return null;
        }
        return findMin().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if(isEmpty()){
            return null;
        }
        return list.remove(findMin());
    }
}
