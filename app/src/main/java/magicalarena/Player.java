package magicalarena;

public class Player {
    private final String name;
    private int health;
    private final int strength;
    private final int attack;
    private final DiceRoller diceRoller;

    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                "health=" + health +
                ", strength=" + strength +
                ", attack=" + attack +
                '}';
    }

    public Player(String name, int health, int strength, int attack, DiceRoller diceRoller) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.diceRoller = diceRoller;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }

    public int rollAttack() {
        return attack * diceRoller.rollDice();
    }

    public int rollDefend() {
        return strength * diceRoller.rollDice();
    }
}
