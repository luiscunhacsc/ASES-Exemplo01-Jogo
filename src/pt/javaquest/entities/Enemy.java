package pt.javaquest.entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe que representa um Inimigo no jogo.
 * Herança: herda características da classe abstrata Actor.
 */
public class Enemy extends Actor {

    private int attackPower;

    public Enemy(String name, int x, int y, int maxHealth, int attackPower) {
        super(name, x, y, maxHealth);
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Implementação concreta do desenho do Inimigo (Polimorfismo).
     */
    @Override
    public void draw(Graphics g, int tileSize) {
        g.setColor(Color.RED); // Inimigo será um quadrado vermelho
        g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
        
        // Desenha a vida do inimigo
        g.setColor(Color.ORANGE);
        int healthBarWidth = (int) (((double) health / maxHealth) * tileSize);
        g.fillRect(x * tileSize, y * tileSize - 5, healthBarWidth, 4);
    }
}
