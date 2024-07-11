package de.game.controllers;

import java.io.IOException;

import de.game.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class GameMapSelectionController {

    @FXML
    private void switchToMainMenu() throws IOException {
        Main.setRoot("mainMenu");
    }

    @FXML
    private void createMapLI() throws IOException {
        switchToGame(19, 10);
    }

    @FXML
    private void createMapES() throws IOException {
        switchToGame(19, 17); 
    }

    @FXML
    private void createMapPD() throws IOException {
        switchToGame(26, 14); 
    }

    private void switchToGame(int rows, int cols) throws IOException {
        FXMLLoader loader = Main.getLoader("gameView");
        GameController controller = loader.getController();
        controller.createGrid(rows, cols);

        Main.setScene(loader);
    }
}
