package map.impl;

import Iterator.ArrayList;
import Iterator.Iterable;
import map.AbstractHashMap;
import map.Entry;

public class ProbeHashMap<K,V> extends AbstractHashMap<K,V> {

    private MapEntry<K,V>[] table;
    private final MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);

    public ProbeHashMap(int capacity, int prime){
        super(capacity, prime);
    }

    public ProbeHashMap(int capacity){
        super(capacity);
    }

    public ProbeHashMap(){
        super();
    }

    @Override
    protected void createTable() {
        table = (MapEntry<K,V>[]) new MapEntry[capacity];
    }

    private boolean isAvailable(int i){
        return table[i] == null || table[i] == DEFUNCT;
    }

    private int findSlot(int h, K k){
        int avail = -1;
        int j = h;
        do{
            if(isAvailable(j)){
                if(avail == -1){
                    avail = j;
                }
                if(table[j] == null){
                    break;
                }
            } else if(table[j].getKey().equals(k)){
                return j;
            }
            j = (j + 1) % capacity;
        }while(j != h);
        return -(avail+1);
    }

    @Override
    protected V bucketGet(int h, K key) {
        int j = findSlot(h, key);
        if(j < 0){
            return null;
        }
        return table[j].getValue();
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        int j = findSlot(h, key);
        if(j >= 0){
            return table[j].setValue(value);
        }
        table[-(j+1)] = new MapEntry<>(key, value);
        n++;
        return null;
    }

    @Override
    protected V bucketRemove(int h, K key) {
        int j = findSlot(h, key);
        if(j < 0){
            return null;
        }
        V temp = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return temp;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<Entry<K,V>>();
        for(int h = 0; h < capacity; h++){
            if(!isAvailable(h)){
                buffer.add(table[h]);
            }
        }
        return buffer;
    }
}
