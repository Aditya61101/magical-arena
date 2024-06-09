package magicalarena;

import java.util.Scanner;

public class App {

    public String getGreetings() {
        return
            "\r\n" + //
                                " __          __  _                            _          __  __             _           _                                 _ _ \r\n" + //
                                " \\ \\        / / | |                          | |        |  \\/  |           (_)         | |     /\\                        | | |\r\n" + //
                                "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___   | \\  / | __ _  __ _ _  ___ __ _| |    /  \\   _ __ ___ _ __   __ _| | |\r\n" + //
                                "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | |\\/| |/ _` |/ _` | |/ __/ _` | |   / /\\ \\ | '__/ _ \\ '_ \\ / _` | | |\r\n" + //
                                "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |  | | (_| | (_| | | (_| (_| | |  / ____ \\| | |  __/ | | | (_| |_|_|\r\n" + //
                                "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_|  |_|\\__,_|\\__, |_|\\___\\__,_|_| /_/    \\_\\_|  \\___|_| |_|\\__,_(_|_)\r\n" + //
                                "                                                                       __/ |                                                  \r\n" + //
                                "                                                                      |___/                                                   \r\n" + //
                                "";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreetings());

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter attributes for Player A...");
        Player playerA = createPlayer(sc);

        System.out.println("Enter attributes for Player B...");
        Player playerB = createPlayer(sc);

        sc.close();
        Game game = new Game(playerA, playerB);
        game.start();
        // System.out.println("Player A: " + playerA);
        // System.out.println("Player B: " + playerB);

    }

    private static Player createPlayer(Scanner sc) {
        System.out.println("Enter player name: ");
        String name = sc.next();
        while (name.isEmpty()) {
            System.out.println("Name length should be greater than 0. Please try again...");
            name = sc.next();
        }

        System.out.println("Enter health: ");
        int health = sc.nextInt();
        while(health <= 0) {
            System.out.println("Health should be positive. Please try again...");
            health = sc.nextInt();
        }

        System.out.println("Enter strength: ");
        int strength = sc.nextInt();
        while(strength <= 0) {
            System.out.println("Strength should be positive. Please try again...");
            strength = sc.nextInt();
        }

        System.out.println("Enter attack: ");
        int attack = sc.nextInt();
        while(attack <= 0) {
            System.out.println("Attack should be positive. Please try again...");
            attack = sc.nextInt();
        }

        DiceRoller diceRoller = new SixFacedDiceRoller();
        return new Player(name, health, strength, attack, diceRoller);
    }
}
