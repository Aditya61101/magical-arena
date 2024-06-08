package magicalarena;

public class SixFacedDiceRoller implements DiceRoller {
    @Override
    public int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}