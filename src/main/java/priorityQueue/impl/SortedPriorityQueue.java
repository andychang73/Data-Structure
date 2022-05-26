package priorityQueue.impl;

import Iterator.LinkedPositionalList;
import Iterator.positionalList.Position;
import priorityQueue.AbstractPriorityQueue;
import priorityQueue.Entry;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    private final LinkedPositionalList<Entry<K,V>> list = new LinkedPositionalList<Entry<K,V>>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newest = new PQEntry<>(key,value);
        Position<Entry<K,V>> walk = list.last();
        while(walk != null && compare(newest, walk.getElement()) < 0){
            walk = list.before(walk);
        }
        if(walk == null){
            list.addFirst(newest);
        }else{
            list.addAfter(walk, newest);
        }
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if(isEmpty()){
            return null;
        }
        return list.first().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if(isEmpty()){
            return null;
        }
        return list.remove(list.first());
    }
}
