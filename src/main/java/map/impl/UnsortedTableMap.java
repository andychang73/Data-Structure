package map.impl;

import Iterator.ArrayList;
import Iterator.Iterable;
import Iterator.Iterator;
import lombok.NoArgsConstructor;
import map.AbstractMap;
import map.Entry;

import java.util.NoSuchElementException;

@NoArgsConstructor
public class UnsortedTableMap<K,V> extends AbstractMap<K,V> {

    protected final ArrayList<MapEntry<K,V>> table = new ArrayList<MapEntry<K,V>>();

    private int findKey(K key){
        for(int i = 0; i < table.size(); i++){
            if(table.get(i).getKey().equals(key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public V get(K key) {
        int i = findKey(key);
        if(i == -1){
            return null;
        }
        return table.get(i).getValue();
    }

    @Override
    public V put(K key, V value) {
        int i = findKey(key);
        if(i == -1){
            table.add(new MapEntry<>(key, value));
            return value;
        }
        return table.get(i).setValue(value);
    }

    @Override
    public V remove(K key) {
        int i = findKey(key);
        if(i == -1){
            return null;
        }
        int n = table.size();
        if(i != n - 1){
            table.set(i, table.get(n - 1));
        }
        return table.remove(i).getValue();
    }

    private class EntryIterator implements Iterator<Entry<K,V>>{

        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < size();
        }

        @Override
        public MapEntry<K, V> next() throws NoSuchElementException {
            if(i >= size()){
                throw new NoSuchElementException();
            }
            return table.get(i++);
        }

        @Override
        public void remove() throws IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    private class EntryIterable implements Iterable<Entry<K,V>>{

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }
}
