package pt.javaquest.entities;

import java.awt.Graphics;

/**
 * Interface que representa qualquer elemento do jogo (Entidade).
 * Demonstra o conceito de Abstração através de Interfaces.
 */
public interface Entity {
    
    /**
     * Retorna o nome da entidade.
     */
    String getName();
    
    /**
     * Retorna a posição X da entidade.
     */
    int getX();
    
    /**
     * Retorna a posição Y da entidade.
     */
    int getY();

    /**
     * Define a nova posição da entidade.
     */
    void setPosition(int x, int y);

    /**
     * Método para desenhar a entidade no ecrã.
     */
    void draw(Graphics g, int tileSize);
}
