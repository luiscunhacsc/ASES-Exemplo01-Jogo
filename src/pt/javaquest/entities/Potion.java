package pt.javaquest.entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Item Cura (Poção).
 * Demonstra Herança e Polimorfismo.
 */
public class Potion extends Item {
    private int healAmount;

    public Potion(int x, int y, int healAmount) {
        super("Poção de Cura", x, y);
        this.healAmount = healAmount;
    }

    @Override
    public void onCollect(Hero hero) {
        hero.heal(healAmount);
    }

    @Override
    public void draw(Graphics g, int tileSize) {
        g.setColor(Color.PINK); // Poções são cor de rosa
        g.fillOval(x * tileSize + 5, y * tileSize + 5, tileSize - 10, tileSize - 10);
    }
}
