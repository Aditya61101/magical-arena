package magicalarena;

public class Player {
    private int health;
    private final int strength;
    private final int attack;
    private final DiceRoller diceRoller;

    public String toString() {
        return "Player{" +
                "health=" + health +
                ", strength=" + strength +
                ", attack=" + attack +
                ", diceRoller=" + diceRoller +
                '}';
    }

    public Player(int health, int strength, int attack, DiceRoller diceRoller) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.diceRoller = diceRoller;
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
