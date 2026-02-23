package pt.javaquest;

import pt.javaquest.engine.GameEngine;
import pt.javaquest.ui.GameWindow;

import javax.swing.JOptionPane;

/**
 * Classe de "Boot" ou Ponto de Entrada para o JavaQuest.
 */
public class Main {
    public static void main(String[] args) {
        // Perguntar ao jogador se quer instruções
        int option = JOptionPane.showConfirmDialog(null,
                "Bem-vindo ao JavaQuest!\nQueres ler as instruções e estratégias antes de começar?",
                "Instruções",
                JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            String instructions = "--- COMO JOGAR ---\n" +
                    "Usa as setas do teclado (ou WASD) para mover o teu Herói (Azul).\n" +
                    "O objetivo é derrotar todos os Inimigos (Vermelhos), incluindo o Boss.\n\n" +
                    "--- ESTRATÉGIA ---\n" +
                    "1. Cuidado com inimigos fortes. Combates são automáticos ao chocar contra eles!\n" +
                    "2. Apanha Poções (Rosas) para recuperar 50 de Vida.\n" +
                    "3. Apanha Espadas (Cinzentas) para aumentar o teu dano de ataque ANTES de enfrentares o Boss Singleton.\n"
                    +
                    "4. Fica sempre de olho na tua vida e no registo de combate no fundo do ecrã.\n\n" +
                    "Boa sorte!";
            JOptionPane.showMessageDialog(null, instructions, "Instruções do JavaQuest",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        // Inicializa o motor do jogo com um mapa 12x10
        GameEngine engine = new GameEngine(12, 10);
        engine.initGame();

        // Inicializa a Janela
        GameWindow window = new GameWindow(engine);
        window.start();
    }
}
