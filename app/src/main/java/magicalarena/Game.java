package magicalarena;

public class Game {
    private final Player playerA;
    private final Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void start() {
        Player firstAttacker;
        Player secondAttacker;

        if (playerA.getHealth() <= playerB.getHealth()) {
            firstAttacker = playerA;
            secondAttacker = playerB;
        } else {
            firstAttacker = playerB;
            secondAttacker = playerA;
        }

        while (firstAttacker.isAlive() && secondAttacker.isAlive()) {
            takeTurn(firstAttacker, secondAttacker);
            if (secondAttacker.isAlive()) {
                takeTurn(secondAttacker, firstAttacker);
            }
        }

        if (firstAttacker.isAlive()) {
            System.out.println(String.format(
                    "Player %s wins!!",
                    firstAttacker.getName()));
        } else {
            System.out.println(String.format(
                    "Player %s wins!!",
                    secondAttacker.getName()));
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
