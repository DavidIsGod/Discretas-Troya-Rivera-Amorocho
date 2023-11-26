package com.example.grafo2.model;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;  // Importar ToggleButton en lugar de RadioButton

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private int id;
    private int peso;

    private  Nodo nodo;

    private int distancia = Integer.MAX_VALUE;
    private Nodo padre;
    private int pesoAcumulado;

    private RadioButton radioButton;


    private ToggleButton button;
    private List<Nodo> nodosAdyacentes;
    private boolean visited;

    public Nodo(int id, int peso, boolean visited) {
        this.id = id;
        this.peso = peso;
        this.visited = visited;
        this.nodosAdyacentes = new ArrayList<>();
    }

    public RadioButton getRadioButton() {
        return radioButton;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public int getPesoAcumulado() {

        return pesoAcumulado;
    }

    public void setPesoAcumulado(int pesoAcumulado) {
        this.pesoAcumulado = pesoAcumulado;
    }
    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public void setNodosAdyacentes(List<Nodo> nodosAdyacentes) {
        this.nodosAdyacentes = nodosAdyacentes;
    }

    public void agregarAdyacente(Nodo adyacente) {
        nodosAdyacentes.add(adyacente);
    }

    public List<Nodo> getNodosAdyacentes() {
        return nodosAdyacentes;
    }

    public ToggleButton getButton() {
        return button;
    }

    public void setButton(ToggleButton button) {
        this.button = button;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setNodo(Nodo nodo){
        this.nodo = nodo;
    }


}
