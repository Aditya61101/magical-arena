package magicalarena;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testGameInitialization() {
        DiceRoller diceRoller = new SixFacedDiceRoller();
        Player playerA = new Player("PlayerA", 50, 5, 10, diceRoller);
        Player playerB = new Player("PlayerB", 100, 10, 5, diceRoller);

        Game game = new Game(playerA, playerB);
        assertTrue(game instanceof Game);
    }

    @Test
    public void testGamePlay() {
        DiceRoller diceRoller = new SixFacedDiceRoller();
        Player playerA = new Player("PlayerA", 50, 5, 10, diceRoller);
        Player playerB = new Player("PlayerB", 100, 10, 5, diceRoller);

        Game game = new Game(playerA, playerB);
        game.start();

        // At least one player should be alive at the end
        assertTrue(playerA.isAlive() || playerB.isAlive());
    }
}
