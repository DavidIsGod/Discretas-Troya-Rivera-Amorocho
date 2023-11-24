package com.example.grafo2.model;

import java.util.*;

public class Dijkstra {
    public int tiempoMasCorto(int n, int k, Graph grafo) {
        SimpleHashMapMap<Integer, List<int[]>> adjacencyList = grafo.getAdjacencyList();

        int[] distancias = new int[n + 1];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[k] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[] {k, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int distancia = current[1];
            int distance = 0;
            if (distance > distancias[node]) {
                continue;
            }

            if (adjacencyList.containsKey(node)) {
                for (int[] edge : adjacencyList.get(node)) {
                    int siguiente = edge[0];
                    int newDistance = distancia + edge[1];

                    if (newDistance < distancias[siguiente]) {
                        distancias[siguiente] = newDistance;
                        minHeap.offer(new int[] {siguiente, newDistance});
                    }
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (distancias[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, distancias[i]);
        }

        return maxTime;
    }
}
