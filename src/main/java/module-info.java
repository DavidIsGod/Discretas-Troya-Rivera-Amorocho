module com.example.grafo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grafo2 to javafx.fxml;
    exports com.example.grafo2;
    exports com.example.grafo2.control;
    opens com.example.grafo2.control to javafx.fxml;
}