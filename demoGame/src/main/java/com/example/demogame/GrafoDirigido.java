package com.example.demogame;
import java.util.Random;

public class GrafoDirigido {
    public static class GrafoUtils {
        public static int[][] generarMatrizAdyacenciaAleatoria(int numNodos) {
            int[][] matrizAdyacencia = new int[numNodos][numNodos];
            Random rand = new Random();


            for (int i = 0; i < numNodos; i++) {
                for (int j = 0; j < numNodos; j++) {
                    matrizAdyacencia[i][j] = rand.nextDouble() < 0.25 ? 1 : 0;
                }
            }

            return matrizAdyacencia;
        }

        public static void imprimirMatrizAdyacencia(int[][] matrizAdyacencia) {
            for (int i = 0; i < matrizAdyacencia.length; i++) {
                for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                    System.out.print(matrizAdyacencia[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void generarGrafo() {
            int numNodos = 50;
            int[][] matrizAdyacencia = generarMatrizAdyacenciaAleatoria(numNodos);
            imprimirMatrizAdyacencia(matrizAdyacencia);
        }
    }


}


