package de.game.model;

import java.util.Random;

public class BattleCalculator {

    private static final Random random = new Random();

    public static boolean doesAttackerWin(Unit attacker, Unit defender) {
        double hitProbability = attacker.getType().getHitProbability();
        double criticalHitChance = attacker.getType().getCriticalHitChance();
        int damage = attacker.getType().getDamage();

        boolean hit = random.nextDouble() < hitProbability;
        boolean criticalHit = random.nextDouble() < criticalHitChance;

        if (hit) {
            if (criticalHit) {
                damage *= 3;
            }
            return damage >= defender.getType().getHp();
        }
        return false;
    }
}