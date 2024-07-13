package de.game.controllers;

import de.game.model.Unit;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameFightController {

    @FXML
    private Label topLeftLabel;

    @FXML
    private Label topRightLabel;

    @FXML
    private Label attackerpicture;

    @FXML
    private Label defenderpicture;

    @FXML
    private Label textLabel1;

    @FXML
    private Label textLabel2;

    @FXML
    private AnchorPane topAnchorPane;

    @FXML
    public void initialize() {
        AnchorPane.setTopAnchor(topLeftLabel, 19.0);
        AnchorPane.setLeftAnchor(topLeftLabel, 19.0);

        AnchorPane.setTopAnchor(topRightLabel, 17.0);
        AnchorPane.setRightAnchor(topRightLabel, 19.0);

        AnchorPane.setTopAnchor(textLabel1, 55.0);
        AnchorPane.setLeftAnchor(textLabel1, 200.0);

        AnchorPane.setTopAnchor(textLabel2, 55.0);
        AnchorPane.setRightAnchor(textLabel2, 200.0);
    }

    public void setAttackerImage(@SuppressWarnings("exports") Unit attacker) {
        attackerpicture.getStyleClass().clear();
        attackerpicture.getStyleClass().addAll(replaceColorClass(attacker.getStyleClass(), false));
        setLabelBackground(topLeftLabel, attacker.getColor());
    }
    
    public void setDefenderImage(@SuppressWarnings("exports") Unit defender) {
        defenderpicture.getStyleClass().clear();
        defenderpicture.getStyleClass().addAll(replaceColorClass(defender.getStyleClass(), true));
        setLabelBackground(topRightLabel, defender.getColor());
    }
    
    private List<String> replaceColorClass(List<String> styleClasses, boolean isDefender) {
        List<String> newClasses = new ArrayList<>();
        for (String styleClass : styleClasses) {
            if (styleClass.equals("blue")) {
                newClasses.add("blueFight");
            } else if (styleClass.equals("red")) {
                newClasses.add("redFight");
            } else {
                newClasses.add(styleClass);
            }
        }
        if (isDefender) {
            newClasses.add("defend");
        }
        return newClasses;
    }
    
    private void setLabelBackground(Label label, String color) {
        Color backgroundColor = color.equals("R") ? Color.RED : Color.BLUE;
        label.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, null)));
    }
    

    private static final Random random = new Random();

    public int calculateDamage(@SuppressWarnings("exports") Unit attacker, @SuppressWarnings("exports") Unit defender) {
        double hitProbability = attacker.getType().getHitProbability();
        double criticalHitChance = attacker.getType().getCriticalHitChance();
        int damage = attacker.getType().getDamage();

        boolean hit = random.nextDouble() < hitProbability;
        boolean criticalHit = random.nextDouble() < criticalHitChance;

        if (hit) {
            if (criticalHit) {
                damage *= 3;
                System.out.println("Kritischer Treffer!");
            }
            System.out.println("Verteidiger Kriegt " + damage + " schaden");
            return damage;
        }
        System.out.println("Verfehlt!");
        return 0;
    }

    public void updateHpLabels(@SuppressWarnings("exports") Unit attacker, @SuppressWarnings("exports") Unit defender) {
        textLabel1.setText("HP: " + attacker.getHp());
        textLabel2.setText("HP: " + defender.getHp());
    }
}
