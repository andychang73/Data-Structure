package map.impl;

import Iterator.ArrayList;
import Iterator.Iterable;
import Iterator.Iterator;
import map.AbstractHashMap;
import map.Entry;

public class ChainHashMap<K,V> extends AbstractHashMap<K,V> {

    private UnsortedTableMap<K,V>[] table;

    public ChainHashMap(int capacity, int prime){
        super(capacity, prime);
    }

    public ChainHashMap(int capacity){
        super(capacity);
    }

    public ChainHashMap(){
        super();
    }

    @Override
    protected void createTable() {
        table = (UnsortedTableMap<K,V>[]) new UnsortedTableMap[capacity];
    }

    @Override
    protected V bucketGet(int h, K key) {
        UnsortedTableMap<K,V> bucket = table[h];
        if(bucket == null){
            return null;
        }
        return bucket.get(key);
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        UnsortedTableMap<K,V> bucket = table[h];
        if(bucket == null){
            bucket = table[h] = new UnsortedTableMap<>();
        }
        return bucket.put(key, value);
    }

    @Override
    protected V bucketRemove(int h, K key) {
        UnsortedTableMap<K,V> bucket = table[h];
        if(bucket == null){
            return null;
        }
        return bucket.remove(key);
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<Entry<K,V>>();
        for(int h = 0; h < table.length; h++){
            if(table[h] != null){
                Iterator<Entry<K,V>> iterator = table[h].entrySet().iterator();
                while(iterator.hasNext()){
                    buffer.add(iterator.next());
                }
            }
        }
        return buffer;
    }
}
