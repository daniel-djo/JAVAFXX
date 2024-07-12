package de.game.model;

import java.util.EnumMap;
import java.util.Map;

public enum UnitType {
    INFANTRY('I', 3, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 2,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    MECHANIZED_INFANTRY('M', 2, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 1,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    TANK('T', 6, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 2,
            TileType.MOUNTAIN, 0,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    MOBILE_ARTILLERY('A', 5, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 2,
            TileType.MOUNTAIN, 0,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    ANTI_AIR('R', 6, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 2,
            TileType.MOUNTAIN, 0,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    FIGHTER('F', 9, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 1,
            TileType.SEA, 1,
            TileType.STREET, 1))),
    BOMBER('B', 7, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 1,
            TileType.SEA, 1,
            TileType.STREET, 1))),
    BATTLE_COPTER('C', 6, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 1,
            TileType.SEA, 1,
            TileType.STREET, 1)));

    private char symbol;
    private int movement;
    private Map<TileType, Integer> movementCosts;

    UnitType(char symbol, int movement, Map<TileType, Integer> movementCosts) {
        this.symbol = symbol;
        this.movement = movement;
        this.movementCosts = movementCosts;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getMovement() {
        return movement;
    }

    public Map<TileType, Integer> getMovementCosts() {
        return movementCosts;
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
