package map;

import Iterator.Iterator;
import Iterator.Iterable;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;

public abstract class AbstractMap<K,V> implements Map<K,V> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @AllArgsConstructor
    protected static class MapEntry<K,V> implements Entry<K,V>{

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

        public void setKey(K k){
            this.k = k;
        }

        public V setValue(V v){
            V old = this.v;
            this.v = v;
            return old;
        }
    }

    private class KeyIterator implements Iterator<K>{

        private final Iterator<Entry<K,V>> iterator = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public K next() throws NoSuchElementException {
            return iterator.next().getKey();
        }

        @Override
        public void remove() throws IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    private class KeyIterable implements Iterable<K>{

        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    @Override
    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    private class ValueIterator implements Iterator<V>{

        private final Iterator<Entry<K,V>> iterator = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public V next() throws NoSuchElementException {
            return iterator.next().getValue();
        }

        @Override
        public void remove() throws IllegalStateException {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterable implements Iterable<V>{

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }
}
