package de.game.controllers;

import de.game.Main;
import de.game.model.Tile;
import de.game.model.TileType;
import de.game.model.Unit;
import de.game.model.UnitType;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;


import java.io.IOException;
import java.util.*;

public class GameController {

    @FXML
    private GridPane gameGrid;

    @FXML
    private Label turnLabel;

    @FXML
    private Button fightButton;

    private Unit selectedUnit;

    private boolean isRedTurn = true;

    private Set<Unit> movedUnits = new HashSet<>();

    private Unit targetUnit;

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
        Unit clickedUnit = (Unit) event.getSource();
        if ((isRedTurn && clickedUnit.getColor().equals("R")) || (!isRedTurn && clickedUnit.getColor().equals("B"))) {
            if (movedUnits.contains(clickedUnit)) {
                return; // Einheit hat sich bereits bewegt
            }

            if (selectedUnit != null) {
                selectedUnit.setSelected(false);
                clearHighlights();
            }

            selectedUnit = clickedUnit;
            selectedUnit.setSelected(true);

            int unitRow = GridPane.getRowIndex(selectedUnit);
            int unitCol = GridPane.getColumnIndex(selectedUnit);

            List<int[]> possibleMoves = calculatePossibleMoves(selectedUnit, unitRow, unitCol);

            highlightPossibleMoves(possibleMoves);
        }
    }

    private List<int[]> calculatePossibleMoves(Unit unit, int unitRow, int unitCol) {
        int movement = unit.getType().getMovement();
        Map<TileType, Integer> movementCosts = unit.getType().getMovementCosts();
        List<int[]> possibleMoves = new ArrayList<>();

        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        Set<Node> closedList = new HashSet<>();

        Node startNode = new Node(unitRow, unitCol, 0);
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            if (!closedList.contains(currentNode)) {
                closedList.add(currentNode);
                possibleMoves.add(new int[]{currentNode.row, currentNode.col});

                for (int[] direction : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                    int newRow = currentNode.row + direction[0];
                    int newCol = currentNode.col + direction[1];

                    if (newRow >= 0 && newRow < gameGrid.getRowCount() && newCol >= 0 && newCol < gameGrid.getColumnCount()) {
                        Tile tile = getTileAt(newRow, newCol);
                        if (tile != null) {
                            TileType tileType = tile.getType();
                            int moveCost = movementCosts.getOrDefault(tileType, Integer.MAX_VALUE);
                            int newCost = currentNode.cost + moveCost;

                            if (moveCost > 0 && newCost <= movement) {
                                Node neighborNode = new Node(newRow, newCol, newCost);
                                openList.add(neighborNode);
                            }
                        }
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
            if (tile != null && !isUnitAt(row, col)) {
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

    private boolean isUnitAt(int row, int col) {
        for (var node : gameGrid.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col && node instanceof Unit) {
                return true;
            }
        }
        return false;
    }

    private void moveUnitToPosition(int targetRow, int targetCol) {
        if (selectedUnit != null && !isUnitAt(targetRow, targetCol)) {
            gameGrid.getChildren().remove(selectedUnit);
            gameGrid.add(selectedUnit, targetCol, targetRow);
            movedUnits.add(selectedUnit);
            clearHighlights();
            selectedUnit.setSelected(false);

            checkForEnemiesInRange(targetRow, targetCol);
        }
    }

    private void clearHighlights() {
        gameGrid.getChildren().removeIf(node -> node instanceof Rectangle);
    }

    @FXML
    private void endTurn() {
        isRedTurn = !isRedTurn;
        turnLabel.setText(isRedTurn ? "Rot ist am Zug" : "Blau ist am Zug");
        movedUnits.clear();
        fightButton.setVisible(false);
        selectedUnit = null; // Beim Beenden des Zugs die ausgewählte Einheit zurücksetzen
    }

    private void checkForEnemiesInRange(int unitRow, int unitCol) {
        if (selectedUnit == null) return;

        int attackRange = selectedUnit.getType().getRange();
        for (int row = unitRow - attackRange; row <= unitRow + attackRange; row++) {
            for (int col = unitCol - attackRange; col <= unitCol + attackRange; col++) {
                if (row >= 0 && row < gameGrid.getRowCount() && col >= 0 && col < gameGrid.getColumnCount()) {
                    if (isEnemyUnitAt(row, col)) {
                        fightButton.setVisible(true);
                        targetUnit = getUnitAt(row, col);
                        return;
                    }
                }
            }
        }
        fightButton.setVisible(false);
        targetUnit = null;
    }

    private boolean isEnemyUnitAt(int row, int col) {
        for (var node : gameGrid.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col && node instanceof Unit) {
                Unit unit = (Unit) node;
                return !unit.getColor().equals(selectedUnit.getColor());
            }
        }
        return false;
    }

    private Unit getUnitAt(int row, int col) {
        for (var node : gameGrid.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col && node instanceof Unit) {
                return (Unit) node;
            }
        }
        return null;
    }

    private void checkForVictory() {
    boolean redHasUnits = false;
    boolean blueHasUnits = false;

    for (var node : gameGrid.getChildren()) {
        if (node instanceof Unit) {
            Unit unit = (Unit) node;
            if (unit.getColor().equals("R")) {
                redHasUnits = true;
            } else if (unit.getColor().equals("B")) {
                blueHasUnits = true;
            }
        }
    }

    if (!redHasUnits || !blueHasUnits) {
        String winningTeam = redHasUnits ? "Rot" : "Blau";
        showVictoryMessage(winningTeam + " gewinnt!");
    }
}

    private void showVictoryMessage(String message) {
        Text victoryText = new Text(message);
        victoryText.setFont(new Font(50));
        victoryText.setFill(Color.RED);
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(victoryText);
        stackPane.setPrefSize(gameGrid.getWidth(), gameGrid.getHeight());
        stackPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8);");
        
        GridPane.setColumnSpan(stackPane, gameGrid.getColumnCount());
        GridPane.setRowSpan(stackPane, gameGrid.getRowCount());
        gameGrid.add(stackPane, 0, 0);
    }


    @FXML
    private void startFight() {
        if (selectedUnit != null && targetUnit != null) {
            try {
                Scene currentScene = gameGrid.getScene();

                FXMLLoader loader = Main.getLoader("gameFight");
                Scene fightScene = new Scene(loader.getRoot(), 800, 600);
                fightScene.getStylesheets().add(Main.class.getResource("/de/game/view/styles.css").toExternalForm()); // CSS hinzufügen
                Main.getPrimaryStage().setScene(fightScene);

                GameFightController fightController = loader.getController();
                fightController.setAttackerImage(selectedUnit);
                fightController.setDefenderImage(targetUnit);

                int damage = fightController.calculateDamage(selectedUnit, targetUnit);

                targetUnit.setHp(targetUnit.getHp() - damage);
                if (targetUnit.getHp() <= 0) {
                    gameGrid.getChildren().remove(targetUnit);
                }

                fightController.updateHpLabels(selectedUnit, targetUnit);

                PauseTransition pause = new PauseTransition(Duration.seconds(5));
                pause.setOnFinished(event -> {
                    Main.getPrimaryStage().setScene(currentScene);
                    checkForVictory();
                });
                pause.play();

                fightButton.setVisible(false);
                targetUnit = null;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static class Node {
        int row, col, cost;

        Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return row == node.row && col == node.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
