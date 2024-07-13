package de.game.model;

import java.util.EnumMap;
import java.util.Map;

public enum UnitType {
    INFANTRY('I', 3, 10, 5, 0.05, 1, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 2,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    MECHANIZED_INFANTRY('M', 2, 10, 6, 0.1, 1, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 1,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    TANK('T', 6, 10, 7, 0.3, 1, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 2,
            TileType.MOUNTAIN, 0,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    MOBILE_ARTILLERY('A', 5, 10, 8, 0.15, 2, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 2,
            TileType.MOUNTAIN, 0,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    ANTI_AIR('R', 6, 10, 7, 0.1, 1, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 2,
            TileType.MOUNTAIN, 0,
            TileType.SEA, 0,
            TileType.STREET, 1))),
    FIGHTER('F', 9, 10,9,0.1,1,new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 1,
            TileType.SEA, 1,
            TileType.STREET, 1))),
    BOMBER('B', 7, 10,8,0.3,1,new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 1,
            TileType.SEA, 1,
            TileType.STREET, 1))),
    BATTLE_COPTER('C', 6, 10, 7, 0.2,1, new EnumMap<TileType, Integer>(Map.of(
            TileType.PLAIN, 1,
            TileType.WOOD, 1,
            TileType.MOUNTAIN, 1,
            TileType.SEA, 1,
            TileType.STREET, 1)));

    private char symbol;
    private int movement;
    private int hp;
    private int range;
    private int damage;
    private double hitProbability;
    private double criticalHitChance;
    private Map<TileType, Integer> movementCosts;

    UnitType(char symbol, int movement, int hp, int damage, double criticalHitChance, int range, Map<TileType, Integer> movementCosts) {
        this.symbol = symbol;
        this.movement = movement;
        this.range = range;
        this.hp = hp;
        this.damage = damage;
        this.criticalHitChance = criticalHitChance;
        this.hitProbability = 0.8;
        this.movementCosts = movementCosts;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getMovement() {
        return movement;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public double getHitProbability() {
        return hitProbability;
    }

    public double getCriticalHitChance() {
        return criticalHitChance;
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
