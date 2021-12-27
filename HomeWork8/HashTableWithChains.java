package HomeWork8;

import java.util.ArrayList;
import java.util.List;

public class HashTableWithChains<K,V> implements HashTable<K,V> {

    private final List<Item<K,V>> [] data;
    private int size;


    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public HashTableWithChains(int initialCapacity){
        this.data = new List[initialCapacity];
    }


    @Override
    public boolean put(K key, V value) {
        if (data[hashFunc(key)] == null){
           ArrayList<Item<K,V>> chain = new ArrayList<>();
           chain.add(new Item<>(key, value));
           data[hashFunc(key)] = chain;
        }
        else data[hashFunc(key)].
                add(new Item<>(key, value));
        size++;
        return true;
    }


    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        if (data[hashFunc(key)] == null) return null;
        for (Item<K,V> item: data[hashFunc(key)]) {
            if (item.getKey().equals(key)) return item.getValue();
        }
        return null;
    }


    @Override
    public V remove(K key) {
        if (data[hashFunc(key)] == null) return null;
        else {
            for (Item<K,V> item: data[hashFunc(key)]) {
                if(item.getKey().equals(key)) return item.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------\n");
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%d = [%s]%n", i, data[i]));
        }
        sb.append("-----------------------\n");
        return sb.toString();
    }
}