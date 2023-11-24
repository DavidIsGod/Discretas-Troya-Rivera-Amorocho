package com.example.grafo2.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private SimpleHashMap<Integer, Stack<Integer>> adjacencyList = new SimpleHashMap<>();

    public void addEdge(int source, int target) {
        adjacencyList.computeIfAbsent(source, k -> new Stack<>()).push(target);
    }

    public SimpleHashMap<Integer, Stack<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    // Método para realizar un recorrido en profundidad (DFS)
    public List<Integer> dfs(int startVertex) {
        List<Integer> visitedVertices = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visitedVertices.contains(currentVertex)) {
                visitedVertices.add(currentVertex);
                Stack<Integer> neighbors = adjacencyList.getOrDefault(currentVertex, new Stack<>());

                while (!neighbors.isEmpty()) {
                    int neighborVertex = neighbors.pop();
                    stack.push(neighborVertex);
                }
            }
        }

        return visitedVertices;
    }
}
