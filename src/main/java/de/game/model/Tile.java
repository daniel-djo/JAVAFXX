package de.game.model;

import javafx.scene.control.Label;

public class Tile extends Label {
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
        setId("tuimg");

        switch (type) {
            case PLAIN:
                getStyleClass().add("plain");
                break;
            case WOOD:
                getStyleClass().add("wood");
                break;
            case MOUNTAIN:
                getStyleClass().add("mountain");
                break;
            case SEA:
                getStyleClass().add("sea");
                break;
            case STREET:
                getStyleClass().add("street");
                break;
        }
    }    
    
}