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
                setId("plain");
                break;
            case WOOD:
                setId("wood");
                break;
            case MOUNTAIN:
                setId("mountain");
                break;
            case SEA:
                setId("sea");
                break;
            case STREET:
                setId("street");
                break;
        }
    }    
    
}