package com.example.demogame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VentanaDeJuego {
    public void mostrarMatrizEnVentana(int[][] matrizAdyacencia) {
        JFrame frame = new JFrame("Grafo Generado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setVisible(true);

        for (int[] ints : matrizAdyacencia) {
            for (int j = 0; j < ints.length; j++) {
                textArea.append(ints[j] + " ");
            }
            textArea.append("\n");
        }
    }

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
}
