package de.game.model;

import javafx.scene.control.Button;

public class Unit extends Button {
    private UnitType type;

    public Unit(UnitType type) {
        this.type = type;
        setUnitAppearance();
    }

    public void setType(UnitType type) {
        this.type = type;
        setUnitAppearance();
    }

    public UnitType getType() {
        return type;
    }

    private void setUnitAppearance() {
        setId("tuimg");  

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
    }
}
