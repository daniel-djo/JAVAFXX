package de.game.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML
    private GridPane gameGrid;

    @FXML
    public void initialize() {
        // Initialisierungslogik
    }

    @FXML
    private void startGame() {
        // Beispielhafte Initialisierung eines Spielfelds mit Buttons
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Button button = new Button();
                button.setPrefSize(50, 50);
                gameGrid.add(button, col, row);
            }
        }
        System.out.println("Spiel gestartet");
    }
}