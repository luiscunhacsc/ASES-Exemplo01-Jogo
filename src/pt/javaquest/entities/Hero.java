package pt.javaquest.entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe que representa o Jogador no jogo.
 * Herda as propriedades de Actor (Herança) e implementa métodos específicos.
 */
public class Hero extends Actor {

    private int attackPower;
    private int score;

    public Hero(String name, int x, int y, int maxHealth, int attackPower) {
        super(name, x, y, maxHealth); // Chama o construtor da superclasse Actor
        this.attackPower = attackPower;
        this.score = 0;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void increaseAttackPower(int amount) {
        this.attackPower += amount;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    /**
     * Implementação concreta do desenho do Herói (Polimorfismo).
     */
    @Override
    public void draw(Graphics g, int tileSize) {
        g.setColor(Color.BLUE); // Herói será um quadrado azul
        g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
        
        // Desenha barra de vida simplificada
        g.setColor(Color.GREEN);
        int healthBarWidth = (int) (((double) health / maxHealth) * tileSize);
        g.fillRect(x * tileSize, y * tileSize - 5, healthBarWidth, 4);
    }
}
