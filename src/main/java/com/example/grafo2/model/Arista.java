package com.example.grafo2.model;

public class Arista <K extends Comparable<K>,V> implements Comparable<Arista<K,V>>{

    private Vertex<K,V> vertex1;
    private Vertex<K,V> vertex2;
    private int weight;

    public Arista(Vertex<K, V> vertex1, Vertex<K, V> vertex2, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public Vertex<K, V> getVertex1() {
        return vertex1;
    }

    public Vertex<K, V> getVertex2() {
        return vertex2;
    }

    public int getWeight() {
        return weight;
    }

    public void setVertex1(Vertex<K, V> vertex1) {
        this.vertex1 = vertex1;
    }

    public void setVertex2(Vertex<K, V> vertex2) {
        this.vertex2 = vertex2;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Arista<K, V> o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Arista{" +
                "vertex1=" + vertex1 +
                ", vertex2=" + vertex2 +
                ", weight=" + weight +
                '}';
    }
}
