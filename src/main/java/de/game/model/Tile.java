package de.game.model;

import javafx.scene.control.Button;

public class Tile extends Button {
    private TileType type;

    public Tile(TileType type) {
        this.type = type;
        setTileAppearance();
    }

    public void setType(TileType type) {
        this.type = type;
        setTileAppearance();
    }

    private void setTileAppearance() {
        switch (type) {
            case PLAIN:
                setStyle("-fx-background-color: lightgreen;");
                break;
            case WOOD:
                setStyle("-fx-background-color: darkgreen;");
                break;
            case MOUNTAIN:
                setStyle("-fx-background-color: gray;");
                break;
            case SEA:
                setStyle("-fx-background-color: blue;");
                break;
        }
    }
}