package pt.javaquest.ui;

import pt.javaquest.engine.GameEngine;

import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Janela do Jogo que interceta os controlos do teclado.
 */
public class GameWindow extends JFrame {

    private GameEngine engine;
    private GamePanel panel;

    public GameWindow(GameEngine engine) {
        this.engine = engine;
        this.panel = new GamePanel(engine);

        setTitle("JavaQuest - Aprender POO Jogando");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        pack();
        setLocationRelativeTo(null); // Centrar no ecrã
        setResizable(false);

        // Controlos de Teclado
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        engine.moveHero(0, -1);
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        engine.moveHero(0, 1);
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        engine.moveHero(-1, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        engine.moveHero(1, 0);
                        break;
                }
                panel.repaint(); // Atualiza a janela visualmente
            }
        });
    }

    public void start() {
        setVisible(true);
    }
}
