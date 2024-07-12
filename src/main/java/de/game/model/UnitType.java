package de.game.model;

public enum UnitType {
    INFANTRY('I', 3),
    MECHANIZED_INFANTRY('M', 2),
    TANK('T', 6),
    MOBILE_ARTILLERY('A', 5),
    ANTI_AIR('R', 6),
    FIGHTER('F', 9),
    BOMBER('B', 7),
    BATTLE_COPTER('C', 6);

    private char symbol;
    private int movement;

    UnitType(char symbol, int movement) {
        this.symbol = symbol;
        this.movement = movement;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getMovement() {
        return movement;
    }

    public static UnitType fromSymbol(char symbol) {
        for (UnitType type : UnitType.values()) {
            if (type.getSymbol() == symbol) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown symbol: " + symbol);
    }
}
