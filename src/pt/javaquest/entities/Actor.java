package pt.javaquest.entities;

/**
 * Classe abstrata base para entidades que se movem e têm vida (Heróis e Inimigos).
 * Demonstra o conceito de Abstração, Encapsulamento e Herança.
 */
public abstract class Actor implements Entity {
    // Encapsulamento: as variáveis são privadas ou protegidas
    protected String name;
    protected int x;
    protected int y;
    protected int health;
    protected int maxHealth;

    public Actor(String name, int x, int y, int maxHealth) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Começa com a vida no máximo
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

    public int getHealth() {
        return health;
    }

    /**
     * Método para receber dano.
     */
    public void takeDamage(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Método para curar.
     */
    public void heal(int amount) {
        this.health += amount;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    // O método draw é obrigatório pela interface Entity, mas será implementado
    // pelas subclasses de forma específica (Polimorfismo).
}
