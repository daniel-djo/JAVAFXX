package de.game.controllers;

import de.game.Main;
import de.game.model.Tile;
import de.game.model.TileType;
import de.game.model.Unit;
import de.game.model.UnitType;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    @FXML
    private GridPane gameGrid;

    private Unit selectedUnit;

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

                if (unitMap != null && !unitMap[row][col].equals(" ")) {
                    char unitSymbol = unitMap[row][col].charAt(0);
                    String unitColor = unitMap[row][col].substring(1);
                    Unit unit = new Unit(UnitType.fromSymbol(unitSymbol), unitColor);
                    unit.setPrefSize(50, 50);
                    unit.setOnMouseClicked(this::handleUnitClick);
                    gameGrid.add(unit, col, row);
                }
            }
        }
    }

    private void handleUnitClick(MouseEvent event) {
        if (selectedUnit != null) {
            selectedUnit.setSelected(false);
            clearHighlights();
        }

        selectedUnit = (Unit) event.getSource();
        selectedUnit.setSelected(true);

        int unitRow = GridPane.getRowIndex(selectedUnit);
        int unitCol = GridPane.getColumnIndex(selectedUnit);

        List<int[]> possibleMoves = calculatePossibleMoves(selectedUnit, unitRow, unitCol);

        highlightPossibleMoves(possibleMoves);
    }

    private List<int[]> calculatePossibleMoves(Unit unit, int unitRow, int unitCol) {
        int movement = unit.getType().getMovement();
        List<int[]> possibleMoves = new ArrayList<>();

        for (int row = unitRow - movement; row <= unitRow + movement; row++) {
            for (int col = unitCol - movement; col <= unitCol + movement; col++) {
                if (row >= 0 && row < gameGrid.getRowCount() && col >= 0 && col < gameGrid.getColumnCount()) {
                    int distance = Math.abs(unitRow - row) + Math.abs(unitCol - col);
                    if (distance <= movement) {
                        possibleMoves.add(new int[]{row, col});
                    }
                }
            }
        }
        return possibleMoves;
    }

    private void highlightPossibleMoves(List<int[]> possibleMoves) {
        for (int[] move : possibleMoves) {
            int row = move[0];
            int col = move[1];

            Tile tile = getTileAt(row, col);
            if (tile != null) {
                double width = tile.getWidth();
                double height = tile.getHeight();

                Rectangle highlight = new Rectangle(width, height);
                highlight.setFill(Color.rgb(0, 0, 255, 0.3));
                gameGrid.add(highlight, col, row);

                highlight.setOnMouseClicked(event -> moveUnitToPosition(row, col));
            }
        }
    }

    private Tile getTileAt(int row, int col) {
        for (var node : gameGrid.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col && node instanceof Tile) {
                return (Tile) node;
            }
        }
        return null;
    }

    private void moveUnitToPosition(int targetRow, int targetCol) {
        if (selectedUnit != null) {
            gameGrid.getChildren().remove(selectedUnit);
            gameGrid.add(selectedUnit, targetCol, targetRow);
            clearHighlights();
            selectedUnit.setSelected(false);
            selectedUnit = null;
        }
    }

    private void clearHighlights() {
        gameGrid.getChildren().removeIf(node -> node instanceof Rectangle);
    }
}
