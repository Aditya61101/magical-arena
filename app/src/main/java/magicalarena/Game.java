package magicalarena;

public class Game {
    private final Player playerA;
    private final Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void start() {
        while (playerA.isAlive() && playerB.isAlive()) {
            takeTurn(playerA, playerB);
            if (playerB.isAlive()) {
                takeTurn(playerB, playerA);
            }
        }

        if (playerA.isAlive()) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }

    private void takeTurn(Player attacker, Player defender) {
        int attackDamage = attacker.rollAttack();
        int defense = defender.rollDefend();
        int damage = Math.max(attackDamage - defense, 0);

        defender.takeDamage(damage);
        System.out.println(String.format(
                "Attacker %s rolls %d attack damage. Defender rolls %d defense. Defender %s takes %d damage. Defender health: %d",
                attacker.getName(), attackDamage, defense, defender.getName(), damage, defender.getHealth()));
    }
}
