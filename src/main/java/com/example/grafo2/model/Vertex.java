package com.example.grafo2.model;

import javafx.scene.paint.Color;

public class Vertex <K extends Comparable<K>,V> implements Comparable<Vertex<K,V>>{

    private K key;
    private V value;

    private Position position;

    private int distance;

    private Color color;
    private boolean visited;

    public Vertex(K key, V value) {
        this.key = key;
        this.value = value;
        this.visited = false;
        distance=0;
    }

    public Vertex(K key) {
        this.key = key;
        this.visited = false;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int compareTo(Vertex<K, V> o) {
        return this.key.compareTo(o.key);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "key=" + key +
                ", value=" + value +
                ", visited=" + visited +
                '}';
    }
}
