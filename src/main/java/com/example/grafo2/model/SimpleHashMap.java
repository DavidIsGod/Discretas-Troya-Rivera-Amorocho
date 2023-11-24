package com.example.grafo2.model;

public class SimpleHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;
    private int size;

    public SimpleHashMap() {
        this.table = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int hash = hash(key);
        int index = hash % table.length;

        if (table[index] == null) {
            table[index] = new Entry<>(hash, key, value, null);
            size++;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = new Entry<>(hash, key, value, null);
                size++;
            }
        }

        if (size > table.length * LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int hash = hash(key);
        int index = hash % table.length;

        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    private static<K> int hash(K key) {
        return key.hashCode();
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    private static class Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K, V> next;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public V getOrDefault(K key, V defaultValue) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }

            int hash = hash(key);
            int index = hash % table.length;

            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }

            return defaultValue;
        }

        public V computeIfAbsent(K key, MyFunction<? super K, ? extends V> mappingFunction) {
            if (key == null || mappingFunction == null) {
                throw new IllegalArgumentException("Key and mappingFunction cannot be null");
            }

            int hash = hash(key);
            int index = hash % table.length;

            Entry<K, V> current = table[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }

            V computedValue = mappingFunction.apply(key);
            if (computedValue != null) {
                put(key, computedValue);
                return computedValue;
            }

            return null;
        }



    }
