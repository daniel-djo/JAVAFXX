package de.game.controllers;

import de.game.Main;
import de.game.model.Tile;
import de.game.model.TileType;
import de.game.model.Unit;
import de.game.model.UnitType;
import javafx.fxml.FXML;
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
    }

    public void createGrid(char[][] map, String[][] unitMap) {
    int rows = map.length;
    int cols = map[0].length;
    gameGrid.getChildren().clear();
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            TileType type = TileType.fromSymbol(map[row][col]);
            Tile tile = new Tile(type);
            tile.setPrefSize(50, 50);
            gameGrid.add(tile, col, row);

            if (unitMap != null && unitMap[row][col] != " ") {
                char unitSymbol = unitMap[row][col].charAt(0);
                String unitColor = unitMap[row][col].substring(1);
                Unit unit = new Unit(UnitType.fromSymbol(unitSymbol), unitColor);
                unit.setPrefSize(50, 50);
                gameGrid.add(unit, col, row);
            }
        }
    }
    }
}
