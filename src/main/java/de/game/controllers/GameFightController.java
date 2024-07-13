package de.game.controllers;

import de.game.Main;
import de.game.model.Unit;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.Random;;

public class GameFightController {

    @FXML
    private Label attackerpicture;

    @FXML
    private Label defenderpicture;

    @FXML
    public void initialize() {
    }

    public void setAttackerImage(Unit attacker) {
        attackerpicture.getStyleClass().clear();
        attackerpicture.getStyleClass().addAll(attacker.getStyleClass());
    }

    public void setDefenderImage(Unit defender) {
        defenderpicture.getStyleClass().clear();
        defenderpicture.getStyleClass().addAll(defender.getStyleClass());
    }

    private static final Random random = new Random();

    public int calculateDamage(Unit attacker, Unit defender) {
        double hitProbability = attacker.getType().getHitProbability();
        double criticalHitChance = attacker.getType().getCriticalHitChance();
        int damage = attacker.getType().getDamage();

        boolean hit = random.nextDouble() < hitProbability;
        boolean criticalHit = random.nextDouble() < criticalHitChance;

        if (hit) {
            if (criticalHit) {
                damage *= 3;
            }
            return damage;
        }
        return 0;
    }
}
