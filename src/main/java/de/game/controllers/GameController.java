package de.game.controllers;

import de.game.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.io.IOException;

public class GameController {

    @FXML
    private GridPane gameGrid;

    @FXML
    public void initialize() {
        // Initialisierungslogik
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Button button = new Button();
                button.setPrefSize(50, 50);
                gameGrid.add(button, col, row);
            }
        }
    }

    @FXML
    private void switchToMainMenu() throws IOException {
        String mainMenuFXML = "mainMenu.fxml";
        System.out.println("Switching to " + mainMenuFXML);
        Main.setRoot(mainMenuFXML);
    }
}
