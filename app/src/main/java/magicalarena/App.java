package magicalarena;

import java.util.Scanner;

public class App {

    public String getGreetings() {
        return "Welcome to Magical Arena!!!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreetings());

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter attributes for Player A...");
        Player playerA = createPlayer(sc);

        System.out.println("Enter attributes for Player B...");
        Player playerB = createPlayer(sc);

        System.out.println("Player A: " + playerA);
        System.out.println("Player B: " + playerB);
        
        sc.close();
    }

    private static Player createPlayer(Scanner sc) {
        // int health = 0, strength = 0, attack = 0;
        System.out.println("Enter health: ");
        int health = sc.nextInt();

        System.out.println("Enter strength: ");
        int strength = sc.nextInt();

        System.out.println("Enter attack: ");
        int attack = sc.nextInt();
        DiceRoller diceRoller = new SixFacedDiceRoller();
        return new Player(health, strength, attack, diceRoller);
    }
}
