package pt.javaquest.engine;

import pt.javaquest.entities.Enemy;
import pt.javaquest.entities.Hero;
import pt.javaquest.entities.Item;
import pt.javaquest.entities.Potion;
import pt.javaquest.entities.Sword;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que orquestra a lógica do jogo (O motor principal).
 * Centraliza as regras e interações entre os objetos.
 */
public class GameEngine {

    private int width;
    private int height;

    private Hero hero;
    private List<Enemy> enemies;
    private List<Item> items;

    private String lastMessage = "Bem-vindo ao JavaQuest!";
    private boolean gameOver = false;

    public GameEngine(int width, int height) {
        this.width = width;
        this.height = height;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public void initGame() {
        // Criar o Herói
        hero = new Hero("Estudante POO", 1, 1, 100, 10);

        // Limpar listas
        enemies.clear();
        items.clear();

        // Adicionar Inimigos
        enemies.add(new Enemy("Bug do NullPointer", 5, 4, 30, 5));
        enemies.add(new Enemy("Bug do Loop Infinito", 8, 2, 40, 8));
        enemies.add(new Enemy("Boss Singleton", 9, 8, 100, 15));

        // Adicionar Itens
        items.add(new Potion(2, 5, 50));
        items.add(new Potion(8, 7, 50));
        items.add(new Sword(4, 2, 20));
    }

    public Hero getHero() {
        return hero;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void moveHero(int dx, int dy) {
        if (gameOver)
            return;

        int newX = hero.getX() + dx;
        int newY = hero.getY() + dy;

        // Verifica limites do mapa
        if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
            return;
        }

        // Verifica combate com inimigo
        Enemy enemyAtPos = getEnemyAt(newX, newY);
        if (enemyAtPos != null) {
            combat(enemyAtPos);
            return; // Atacou, não anda
        }

        // Verifica recolha de item
        Item itemAtPos = getItemAt(newX, newY);
        if (itemAtPos != null) {
            itemAtPos.onCollect(hero);
            items.remove(itemAtPos);
            lastMessage = "Apanhaste " + itemAtPos.getName() + "!";
        }

        // Se estiver livre, move-se
        hero.setPosition(newX, newY);
    }

    private void combat(Enemy enemy) {
        // Herói ataca
        enemy.takeDamage(hero.getAttackPower());
        lastMessage = "Atacaste " + enemy.getName() + " por " + hero.getAttackPower() + " dano!";

        if (!enemy.isAlive()) {
            enemies.remove(enemy);
            lastMessage = "Derrotaste " + enemy.getName() + "!";
            hero.addScore(50);
            checkVictory();
            return;
        }

        // Inimigo ataca de volta
        hero.takeDamage(enemy.getAttackPower());
        lastMessage += " E recebeste " + enemy.getAttackPower() + " dano!";

        if (!hero.isAlive()) {
            gameOver = true;
            lastMessage = "O herói foi derrotado! FIM DE JOGO.";
        }
    }

    private Enemy getEnemyAt(int x, int y) {
        for (Enemy e : enemies) {
            if (e.getX() == x && e.getY() == y)
                return e;
        }
        return null;
    }

    private Item getItemAt(int x, int y) {
        for (Item i : items) {
            if (i.getX() == x && i.getY() == y)
                return i;
        }
        return null;
    }

    private void checkVictory() {
        if (enemies.isEmpty()) {
            gameOver = true;
            lastMessage = "Todos os bugs corrigidos! VITÓRIA TOTAL!";
        }
    }
}
