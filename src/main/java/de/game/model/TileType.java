package de.game.model;

public enum TileType {
    PLAIN('P'),
    WOOD('W'),
    MOUNTAIN('M'),
    SEA('S'),
    STREET('T');

    private char symbol;

    TileType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static TileType fromSymbol(char symbol) {
        for (TileType type : TileType.values()) {
            if (type.getSymbol() == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown symbol: " + symbol);
    }
}
