package magicalarena;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SixFacedDiceRollerTest {

    @Test
    public void testDiceRollRange() {
        DiceRoller diceRoller = new SixFacedDiceRoller();
        for (int i = 0; i < 100; i++) {
            int roll = diceRoller.rollDice();
            assertTrue(roll >= 1 && roll <= 6);
        }
    }
}