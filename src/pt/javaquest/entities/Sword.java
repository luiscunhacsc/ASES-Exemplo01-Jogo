package pt.javaquest.entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Item Arma (Espada).
 * Demonstra Herança e Polimorfismo.
 */
public class Sword extends Item {
    private int damageBoost;

    public Sword(int x, int y, int damageBoost) {
        super("Espada AFIADA", x, y);
        this.damageBoost = damageBoost;
    }

    @Override
    public void onCollect(Hero hero) {
        hero.increaseAttackPower(damageBoost);
    }

    @Override
    public void draw(Graphics g, int tileSize) {
        g.setColor(Color.LIGHT_GRAY); // Espadas são cinza
        // Desenha um formato de espada simples
        g.fillRect(x * tileSize + tileSize / 2 - 2, y * tileSize + 5, 4, tileSize - 10);
        g.fillRect(x * tileSize + 5, y * tileSize + tileSize / 2 + 2, tileSize - 10, 4);
    }
}
