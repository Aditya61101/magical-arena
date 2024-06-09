package magicalarena;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        DiceRoller diceRoller = new SixFacedDiceRoller();
        Player player = new Player("TestPlayer", 100, 10, 20, diceRoller);

        assertEquals("TestPlayer", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(20, player.getAttack());
    }

    @Test
    public void testPlayerHealthReduction() {
        DiceRoller diceRoller = new SixFacedDiceRoller();
        Player player = new Player("TestPlayer", 100, 10, 20, diceRoller);

        player.takeDamage(30);
        assertEquals(70, player.getHealth());

        player.takeDamage(70);
        assertEquals(0, player.getHealth());

        assertTrue(!player.isAlive());
    }

    @Test
    public void testPlayerRollAttackAndDefend() {
        DiceRoller diceRoller = new SixFacedDiceRoller();
        Player player = new Player("TestPlayer", 100, 10, 20, diceRoller);

        int attack = player.rollAttack();
        int defend = player.rollDefend();

        assertTrue(attack >= 20 && attack <= 120); // Attack value * dice roll (1-6)
        assertTrue(defend >= 10 && defend <= 60);  // Strength value * dice roll (1-6)
    }
}