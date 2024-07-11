package de.game.controllers;

import de.game.Main;
import de.game.model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.io.IOException;

public class GameController {

    @FXML
    private GridPane gameGrid;

    @FXML
    public void initialize() {
        System.out.println("GameController initialized");
    }

    @FXML
    private void switchToMainMenu() throws IOException {
        String mainMenuFXML = "mainMenu.fxml";
        System.out.println("Switching to " + mainMenuFXML);
        Main.setRoot(mainMenuFXML);
    }

    public void Game() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
    }

    public void createGrid(int rows, int cols) {
        gameGrid.getChildren().clear();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Button button = new Button();
                button.setPrefSize(50, 50);
                gameGrid.add(button, col, row);
            }
        }
    }
}
