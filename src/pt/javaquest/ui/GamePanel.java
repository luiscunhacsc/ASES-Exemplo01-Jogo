package pt.javaquest.ui;

import pt.javaquest.engine.GameEngine;
import pt.javaquest.entities.Enemy;
import pt.javaquest.entities.Item;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Componente de visualização do jogo.
 * Aprende a delegar o desenho para cada objeto (Polimorfismo).
 */
public class GamePanel extends JPanel {

    private GameEngine engine;
    private int tileSize = 40;

    public GamePanel(GameEngine engine) {
        this.engine = engine;
        int pw = engine.getWidth() * tileSize;
        int ph = engine.getHeight() * tileSize;
        setPreferredSize(new Dimension(pw, ph + 50)); // +50 para o painel de mensagens
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenhar Chão (Grelha)
        g.setColor(new Color(20, 20, 20));
        for (int i = 0; i < engine.getWidth(); i++) {
            for (int j = 0; j < engine.getHeight(); j++) {
                g.drawRect(i * tileSize, j * tileSize, tileSize, tileSize);
            }
        }

        // Desenhar Itens
        for (Item item : engine.getItems()) {
            item.draw(g, tileSize); // Polimorfismo e Abstração em ação
        }

        // Desenhar Inimigos
        for (Enemy enemy : engine.getEnemies()) {
            enemy.draw(g, tileSize);
        }

        // Desenhar Herói se estiver vivo
        if (engine.getHero().isAlive()) {
            engine.getHero().draw(g, tileSize);
        }

        // Desenhar Interface (HUD)
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        int hudY = engine.getHeight() * tileSize + 20;

        String stats = String.format("HP: %d/%d   Ataque: %d   Pontos: %d",
                engine.getHero().getHealth(),
                100, // max health base
                engine.getHero().getAttackPower(),
                engine.getHero().getScore());
        g.drawString(stats, 10, hudY);

        // Mensagem de log
        g.setColor(Color.YELLOW);
        g.drawString(engine.getLastMessage(), 10, hudY + 20);

        // Game Over
        if (engine.isGameOver()) {
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("FIM DE JOGO", getWidth() / 2 - 120, getHeight() / 2);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString(engine.getLastMessage(), getWidth() / 2 - 150, getHeight() / 2 + 40);
        }
    }
}
