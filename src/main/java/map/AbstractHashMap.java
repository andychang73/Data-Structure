package map;

import Iterator.Iterator;
import Iterator.ArrayList;

import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
    protected int n = 0;
    protected int capacity;
    private final int prime;
    private final long scale, shift;

    public AbstractHashMap(int capacity, int prime){
        this.capacity = capacity;
        this.prime = prime;
        Random random = new Random();
        scale = random.nextInt(prime - 1) + 1;
        shift = random.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int capacity){
        this(capacity, 31);
    }

    public AbstractHashMap(){
        this(17);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    @Override
    public V put(K key, V value) {
        V temp = bucketPut(hashValue(key), key, value);
        if(n > capacity / 2){
            resize(2 * capacity + 1);
        }
        return temp;
    }

    @Override
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    protected abstract void createTable();
    protected abstract V bucketGet(int h, K key);
    protected abstract V bucketPut(int h, K key, V value);
    protected abstract V bucketRemove(int h, K key);

    private int hashValue(K key){
        return (int)((Math.abs(key.hashCode() * scale + shift) % prime) % capacity );
    }

    private void resize(int newCap){
        ArrayList<Entry<K,V>> buffer = new ArrayList<Entry<K,V>>();
        Iterator<Entry<K,V>> iterator = entrySet().iterator();
        while(iterator.hasNext()){
            buffer.add(iterator.next());
        }
        capacity = newCap;
        createTable();
        n = 0;
        for(int i = 0; i < buffer.size(); i++){
            Entry<K,V> entry = buffer.get(i);
            put(entry.getKey(), entry.getValue());
        }
    }
}
