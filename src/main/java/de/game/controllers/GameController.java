package de.game.controllers;

import de.game.Main;
import de.game.model.Tile;
import de.game.model.TileType;
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
    }

    @FXML
    private void switchToMainMenu() throws IOException {
        Main.setRoot("mainMenu");
    }

    public void Game() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
    }

    public void createGrid(char[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        gameGrid.getChildren().clear();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                TileType type = TileType.fromSymbol(map[row][col]);
                Tile tile = new Tile(type);
                tile.setPrefSize(50, 50);
                gameGrid.add(tile, col, row);
            }
        }
    }
}
