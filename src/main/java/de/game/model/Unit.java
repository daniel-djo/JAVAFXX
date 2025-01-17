package de.game.model;

import javafx.scene.control.Button;

public class Unit extends Button {
    private UnitType type;
    private String color;
    private boolean selected;
    private int hp;

    public Unit(UnitType type, String color) {
        this.type = type;
        this.color = color;
        this.hp = type.getHp();  // Initialisiert die HP basierend auf dem UnitType
        this.selected = false;
        setUnitAppearance();
    }

    public void setType(UnitType type, String color) {
        this.type = type;
        this.color = color;
        this.hp = type.getHp();  // Aktualisiert die HP beim Setzen des Typs
        setUnitAppearance();
    }

    public UnitType getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        setUnitAppearance();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp < 0) {
            this.hp = 0;
        }
        setUnitAppearance();
    }

    private void setUnitAppearance() {
        setId("tuimg");

        getStyleClass().clear();
        switch (type) {
            case INFANTRY:
                getStyleClass().add("infantry");
                break;
            case MECHANIZED_INFANTRY:
                getStyleClass().add("mechanized_infantry");
                break;
            case TANK:
                getStyleClass().add("tank");
                break;
            case MOBILE_ARTILLERY:
                getStyleClass().add("mobile_artillery");
                break;
            case ANTI_AIR:
                getStyleClass().add("anti_air");
                break;
            case FIGHTER:
                getStyleClass().add("fighter");
                break;
            case BOMBER:
                getStyleClass().add("bomber");
                break;
            case BATTLE_COPTER:
                getStyleClass().add("battle_copter");
                break;
        }

        switch (color) {
            case "R":
                getStyleClass().add("red");
                break;
            case "B":
                getStyleClass().add("blue");
                break;
        }
    }
}
