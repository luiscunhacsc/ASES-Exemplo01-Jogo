package pt.javaquest.entities;

import java.awt.Graphics;

/**
 * Representa um item estático abstrato (Herança, Abstração).
 */
public abstract class Item implements Entity {
    protected String name;
    protected int x;
    protected int y;

    public Item(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Método a ser implementado por subclasses
    public abstract void onCollect(Hero hero);
}
