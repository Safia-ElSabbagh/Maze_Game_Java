import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("========================");
            System.out.println("Welcome to Maze game!");
            System.out.println("========================");

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose an option:\nA) Start the game\nB) Exit the game");
            String answer = scanner.nextLine().toUpperCase();


            switch (answer) {

                case "A":
                    System.out.print("Enter your name: ");
                    String playerName = scanner.nextLine();
                    Maze game = new Maze();
                    Character character = new Character(playerName);
                    game.placeItems(10, 'M'); // Place 10 random monsters
                    game.placeItems(5, 'H'); // Place 5 random Health
                    game.placeItems(4, 'P');// Place 4 random Power
                    game.updatePosition(character, 0, 0); // place the character at the top left
                    character.startGame(game);
                    break;

                case "B":
                    System.out.println("bye");
                    return;

                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }
}

