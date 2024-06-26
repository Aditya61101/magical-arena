package magicalarena;

import java.util.Scanner;

public class App {

    public String getGreetings() {
        return "\r\n" + //
                " __          __  _                            _          __  __             _           _                                 _ _ \r\n"
                + //
                " \\ \\        / / | |                          | |        |  \\/  |           (_)         | |     /\\                        | | |\r\n"
                + //
                "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___   | \\  / | __ _  __ _ _  ___ __ _| |    /  \\   _ __ ___ _ __   __ _| | |\r\n"
                + //
                "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | |\\/| |/ _` |/ _` | |/ __/ _` | |   / /\\ \\ | '__/ _ \\ '_ \\ / _` | | |\r\n"
                + //
                "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |  | | (_| | (_| | | (_| (_| | |  / ____ \\| | |  __/ | | | (_| |_|_|\r\n"
                + //
                "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_|  |_|\\__,_|\\__, |_|\\___\\__,_|_| /_/    \\_\\_|  \\___|_| |_|\\__,_(_|_)\r\n"
                + //
                "                                                                       __/ |                                                  \r\n"
                + //
                "                                                                      |___/                                                   \r\n"
                + //
                "";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreetings());

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter attributes for Player A...");
        Player playerA = createPlayer(sc);
        sc.nextLine();
        System.out.println("Enter attributes for Player B...");
        Player playerB = createPlayer(sc);

        sc.close();
        Game game = new Game(playerA, playerB);
        game.start();
    }

    public static Player createPlayer(Scanner sc) {
        System.out.println("Enter player name: ");
        String name = sc.nextLine();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name length should be greater than 0.");
        }

        System.out.println("Enter health: ");
        int health = takeInput(sc);

        System.out.println("Enter strength: ");
        int strength = takeInput(sc);

        System.out.println("Enter attack: ");
        int attack = takeInput(sc);

        DiceRoller diceRoller = new SixFacedDiceRoller();
        return new Player(name, health, strength, attack, diceRoller);
    }

    private static int takeInput(Scanner sc) {
        int input = -1;
        try {
            input = sc.nextInt();
            if (input <= 0) {
                throw new IllegalArgumentException("Input must be a positive integer.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return input;
    }
}