package com.example.grafo2.control;

import com.example.grafo2.model.Nodo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;


public class JuegoController implements Initializable {


    @FXML
    public RadioButton Tesoro;
    public Button primButton;
    @FXML
    private Button dijkstraButton;
    @FXML
    public RadioButton num1;
    @FXML
    public RadioButton num2;
    @FXML
    public RadioButton num3;
    @FXML
    public RadioButton num4;
    @FXML
    public RadioButton num5;
    @FXML
    public RadioButton num6;
    @FXML
    public RadioButton num7;
    @FXML
    public RadioButton num8;
    @FXML
    public RadioButton num9;
    @FXML
    public RadioButton num10;
    @FXML
    public RadioButton num11;
    @FXML
    public RadioButton num12;
    @FXML
    public RadioButton num13;
    @FXML
    public RadioButton num14;
    @FXML
    public RadioButton num15;
    @FXML
    public RadioButton num16;
    @FXML
    public RadioButton num17;
    @FXML
    public RadioButton num18;
    @FXML
    public RadioButton num19;

    @FXML
    public RadioButton num20;

    @FXML
    public RadioButton num21;

    @FXML
    public RadioButton num22;

    @FXML
    public RadioButton num23;
    @FXML
    public RadioButton num24;

    @FXML
    public RadioButton num25;

    @FXML
    public RadioButton num26;

    @FXML
    public RadioButton num27;

    @FXML
    public RadioButton num28;

    @FXML
    public RadioButton num29;

    @FXML
    public RadioButton num30;

    @FXML
    public RadioButton num31;

    @FXML
    private RadioButton Inicio;

    @FXML
    private Canvas canvas;
    private List<ToggleButton> buttonList;
    private List<Nodo> nodos;
    private Nodo nodoActual;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nodos = new ArrayList<>();
        buttonList = new ArrayList<>();

        dijkstraButton.setOnAction(this::handleDijkstraButtonClick);


        List<RadioButton> radioButtons = Arrays.asList(
                Tesoro, num1, num2, num3, num4, num5, num6, num7, num8, num9,
                num10, num11, num12, num13, num14, num15, num16, num17, num18, num19,
                num20, num21, num22, num23, num24, num25, num26, num27, num28, num29,
                num30, num31, Inicio
        );

        Image backgroundImage = new Image(getClass().getResourceAsStream("/portada/Map Maze xd.jpg"));
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(backgroundImage, 0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i = 0; i < 34; i++) {
            int peso = 0;
            Nodo nodo;
            if (nodos.isEmpty()) {
                nodo = new Nodo(i, peso, false);
            } else {
                nodo = new Nodo(i, peso+2, false);
            }
            nodos.add(nodo);


            ToggleButton button = new ToggleButton(Integer.toString(i));
            buttonList.add(button);

            final int buttonIndex = i;
            button.setOnAction(event -> {
                System.out.println("Botón " + buttonIndex + " clicado");


                for (RadioButton rb : radioButtons) {
                    rb.setDisable(true);
                }


                habilitarNodosAdyacentes(buttonIndex);
            });
        }

        conectarNodos(new ArrayList<>(nodos));


        conectarNodos(new ArrayList<>(nodos));

        for (RadioButton button : radioButtons) {
            button.setOnAction(event -> handleButtonClick(button));
            Tesoro.setOnAction(event -> handleTesoroButtonClick(32));
        }
        primButton.setOnAction(event -> marcarBotonesEnCamino(nodos));

    }

    private void handleDijkstraButtonClick(ActionEvent event) {
        System.out.println("Dijkstra button clicked");

        Nodo inicio = nodos.get(0);
        Nodo tesoro = nodos.get(32);

        dijkstra(inicio);
        List<Nodo> camino = buscarCaminoDFS(inicio, tesoro);

        if (camino.isEmpty()) {
            mostrarAlerta("¡Advertencia!", "No hay un camino válido al tesoro.", Alert.AlertType.WARNING);
        } else {
            marcarBotonesEnCamino(camino);
        }
    }
    private List<Nodo> buscarCaminoDFS(Nodo inicio, Nodo tesoro) {
        Set<Nodo> visitados = new HashSet<>();
        List<Nodo> camino = new ArrayList<>();
        dfs(inicio, tesoro, visitados, camino);
        return camino;
    }

    private void dfs(Nodo actual, Nodo tesoro, Set<Nodo> visitados, List<Nodo> camino) {
        visitados.add(actual);
        camino.add(actual);

        if (actual.equals(tesoro)) {
            return;
        }

        for (Nodo adyacente : actual.getNodosAdyacentes()) {
            if (!visitados.contains(adyacente)) {
                dfs(adyacente, tesoro, visitados, camino);
            }
        }

        if (!camino.isEmpty() && !camino.get(camino.size() - 1).equals(tesoro)) {
            camino.remove(camino.size() - 1);
        }
    }


    private void marcarBotonesEnCamino(List<Nodo> nodos) {
        System.out.println("Esta es la ruta que te lleva hasta el tesoro");
        for (Nodo nodo : nodos) {
            ToggleButton boton = nodo.getButton();
            if (boton != null) {
                System.out.println("Marcando botón: " + boton.getText());  // Agrega esta línea para depurar
                boton.setStyle("-fx-background-color: blue;");
            }
        }
        mostrarAlerta("¡Felicidades!", "Has llegado al tesoro.", Alert.AlertType.INFORMATION);
    }



    private void dijkstra(Nodo inicio) {
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Nodo::getPesoAcumulado));
        inicio.setPesoAcumulado(0);
        colaPrioridad.add(inicio);

        while (!colaPrioridad.isEmpty()) {
            Nodo nodoActual = colaPrioridad.poll();

            for (Nodo adyacente : nodoActual.getNodosAdyacentes()) {
                int nuevoPeso = nodoActual.getPesoAcumulado() + adyacente.getPeso();

                if (nuevoPeso < adyacente.getPesoAcumulado()) {
                    adyacente.setPesoAcumulado(nuevoPeso);
                    adyacente.setPadre(nodoActual);
                    colaPrioridad.add(adyacente);
                }
            }
        }
    }


    private void handleButtonClick(RadioButton button) {
        System.out.println("Botón " + button.getText() + " clicado");


        if (button == Inicio) {
            handleInicioButtonClick(0);

        } else {

            handleOtherButtonClick(button, nodoActual);
        }


    }

    private void handleInicioButtonClick(int indiceBoton) {
        System.out.println("Es el botón Inicio");


        if (!nodos.get(indiceBoton).isVisited()) {
            Inicio.setStyle("-fx-background-color: green;");
            imprimirAdyacentes(indiceBoton);


            habilitarNodosAdyacentes(indiceBoton);
        } else {
            mostrarAlerta("¡¡Advertencia!!", "Este nodo ya fue visitado.", Alert.AlertType.WARNING);
        }
    }
    private void handleTesoroButtonClick(int indiceBoton) {
        System.out.println("Es el botón Tesoro");

        if (!nodos.get(indiceBoton).isVisited()) {
            Tesoro.setStyle("-fx-background-color: green;");
            imprimirAdyacentes(indiceBoton);

            // Aquí puedes agregar acciones adicionales específicas para el nodo Tesoro si es necesario.

            mostrarAlerta("¡¡Felicidades!!", "Has llegado al nodo Tesoro.", Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("¡¡Advertencia!!", "Este nodo Tesoro ya fue visitado.", Alert.AlertType.WARNING);
        }
    }


    private void handleOtherButtonClick(RadioButton button, Nodo inicio) {
        System.out.println("Es otro botón");

        int indiceBotonClickeado = 0;

        try {
            String buttonText = button.getId().substring(3);
            indiceBotonClickeado = Integer.parseInt(buttonText);

        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            return;
        }

        Nodo nodoClickeado = nodos.get(indiceBotonClickeado);

        imprimirAdyacentes(indiceBotonClickeado);

        if (nodoActual == null || esAdyacenteAlNodoActual(nodoClickeado)) {
            if (!nodoClickeado.isVisited()) {
                nodoClickeado.setVisited(true);
                button.setStyle("-fx-background-color: green;");

                if (nodoActual != null && nodoActual.getButton() != null) {
                    nodoActual.getButton().setStyle("");
                }

                nodoActual = nodoClickeado;

                habilitarNodosAdyacentes(indiceBotonClickeado);
            } else {
                nodoActual = nodoClickeado;
                mostrarAlerta("¡¡Advertencia!!", "Este nodo ya fue visitado.", Alert.AlertType.WARNING);
            }
        } else {
            mostrarAlerta("¡¡Advertencia!!", "Este nodo no es adyacente al nodo actual.", Alert.AlertType.WARNING);
        }
    }




    private void habilitarNodosAdyacentes(int indiceBotonClickeado) {
        Nodo nodoClickeado = nodos.get(indiceBotonClickeado);

        for (Nodo adyacente : nodoClickeado.getNodosAdyacentes()) {
            adyacente.getButton().setDisable(false);
        }
    }

    private void imprimirAdyacentes(int indiceBotonClickeado) {
        Nodo nodoClickeado = nodos.get(indiceBotonClickeado);


        List<Nodo> adyacentes = nodoClickeado.getNodosAdyacentes();

        System.out.println("Nodos adyacentes al botón " + indiceBotonClickeado + ":");

        for (Nodo adyacente : adyacentes) {
            System.out.println("Botón " + adyacente.getId());
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }


    private void conectarNodos(ArrayList<Nodo> nodos) {
        nodos.get(0).agregarAdyacente(nodos.get(1));
        nodos.get(1).agregarAdyacente(nodos.get(0));
        nodos.get(1).agregarAdyacente(nodos.get(2));
        nodos.get(2).agregarAdyacente(nodos.get(1));
        nodos.get(1).agregarAdyacente(nodos.get(5));
        nodos.get(5).agregarAdyacente(nodos.get(1));
        nodos.get(1).agregarAdyacente(nodos.get(17));
        nodos.get(17).agregarAdyacente(nodos.get(1));

        nodos.get(2).agregarAdyacente(nodos.get(3));
        nodos.get(3).agregarAdyacente(nodos.get(2));
        nodos.get(3).agregarAdyacente(nodos.get(4));
        nodos.get(4).agregarAdyacente(nodos.get(3));


        nodos.get(5).agregarAdyacente(nodos.get(6));
        nodos.get(6).agregarAdyacente(nodos.get(5));
        nodos.get(6).agregarAdyacente(nodos.get(7));
        nodos.get(7).agregarAdyacente(nodos.get(6));
        nodos.get(7).agregarAdyacente(nodos.get(9));
        nodos.get(9).agregarAdyacente(nodos.get(7));
        nodos.get(7).agregarAdyacente(nodos.get(8));
        nodos.get(8).agregarAdyacente(nodos.get(7));
        nodos.get(8).agregarAdyacente(nodos.get(16));
        nodos.get(16).agregarAdyacente(nodos.get(8));

        nodos.get(9).agregarAdyacente(nodos.get(10));
        nodos.get(10).agregarAdyacente(nodos.get(9));
        nodos.get(9).agregarAdyacente(nodos.get(11));
        nodos.get(11).agregarAdyacente(nodos.get(9));
        nodos.get(11).agregarAdyacente(nodos.get(12));
        nodos.get(12).agregarAdyacente(nodos.get(11));
        nodos.get(13).agregarAdyacente(nodos.get(14));
        nodos.get(14).agregarAdyacente(nodos.get(13));
        nodos.get(14).agregarAdyacente(nodos.get(15));
        nodos.get(15).agregarAdyacente(nodos.get(14));

        nodos.get(17).agregarAdyacente(nodos.get(18));
        nodos.get(18).agregarAdyacente(nodos.get(17));
        nodos.get(18).agregarAdyacente(nodos.get(19));
        nodos.get(19).agregarAdyacente(nodos.get(18));
        nodos.get(18).agregarAdyacente(nodos.get(20));
        nodos.get(20).agregarAdyacente(nodos.get(18));
        nodos.get(20).agregarAdyacente(nodos.get(21));
        nodos.get(21).agregarAdyacente(nodos.get(20));
        nodos.get(21).agregarAdyacente(nodos.get(22));
        nodos.get(22).agregarAdyacente(nodos.get(21));
        nodos.get(21).agregarAdyacente(nodos.get(23));
        nodos.get(23).agregarAdyacente(nodos.get(21));
        nodos.get(23).agregarAdyacente(nodos.get(24));
        nodos.get(24).agregarAdyacente(nodos.get(23));
        nodos.get(24).agregarAdyacente(nodos.get(25));
        nodos.get(25).agregarAdyacente(nodos.get(24));
        nodos.get(25).agregarAdyacente(nodos.get(26));
        nodos.get(26).agregarAdyacente(nodos.get(25));
        nodos.get(25).agregarAdyacente(nodos.get(27));
        nodos.get(27).agregarAdyacente(nodos.get(25));
        nodos.get(27).agregarAdyacente(nodos.get(28));
        nodos.get(28).agregarAdyacente(nodos.get(27));
        nodos.get(28).agregarAdyacente(nodos.get(29));
        nodos.get(29).agregarAdyacente(nodos.get(28));
        nodos.get(29).agregarAdyacente(nodos.get(30));
        nodos.get(30).agregarAdyacente(nodos.get(29));
        nodos.get(30).agregarAdyacente(nodos.get(31));
        nodos.get(31).agregarAdyacente(nodos.get(30));
        nodos.get(31).agregarAdyacente(nodos.get(32));
        nodos.get(32).agregarAdyacente(nodos.get(31));

        for (Nodo nodo : nodos) {
            List<Nodo> adyacentes = nodo.getNodosAdyacentes();
            for (Nodo adyacente : adyacentes) {

                System.out.println("Conexión: " + nodo.getId() + " -> " + adyacente.getId());
            }
        }
        for (int i = 0; i < nodos.size(); i++) {
            nodos.get(i).setButton(buttonList.get(i));
        }

    }

    private boolean esAdyacenteAlNodoActual(Nodo nodo) {
        return nodoActual != null && nodoActual.getNodosAdyacentes().contains(nodo);
    }


}
