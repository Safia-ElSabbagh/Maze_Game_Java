import java.util.Scanner;
import java.util.Random;

public class Character {

    Random random = new Random();
    int[] position;
    int power = 100;
    int health = 100;
    char symbol;


    public Character(String name) {
        this.position = new int[]{0, 0};
        this.power = 100;
        this.health = 100;
        this.random = new Random();
        this.symbol = name.charAt(0);  //take the first character of the player's name
    }


    public void move(int rowChange, int colChange, Maze maze) {
        try {
            int row = position[0] + rowChange;
            int col = position[1] + colChange;
            char item = maze.getItem(row, col);

            if (item == 'H') {
                HealthItem healthItem = new HealthItem();
                health += healthItem.applyEffect();
                maze.updatePosition(this, row, col);
            } else if (item == 'P') {
                PowerItem powerItem = new PowerItem();
                power += powerItem.applyEffect();
                maze.updatePosition(this, row, col);
            } else if (item == 'M') {
                Monster monster = new Monster();
                int monPower = monster.getPower();
                if (power >= monPower) {
                    System.out.println("\n^^^ Defeated the monster ^^^ ");
                    health += 10;
                } else {
                    System.out.println(" ^Defeated^ ");
                    health -= 50;
                    power -= monPower;
                }
                maze.updatePosition(this, row, col);
            } else {
                maze.updatePosition(this, row, col);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nCan't move in that direction, you're at the edge of the maze!");
        }
    }

    public void startGame(Maze maze) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            if (power <= 0) {
                System.out.println("\nYou lose");
                return;
            }
            maze.displayMaze();
            System.out.println("Current Position: (" + position[0] + ", " + position[1] + ")");
            System.out.println("Current Power = " + power);
            System.out.println("Current Health = " + health);
            System.out.println("Enter direction (up, down, left, right) :");
            command = scanner.nextLine();

            switch (command) {
                case "up":
                    move(-1, 0, maze);
                    break;
                case "down":
                    move(1, 0, maze);
                    break;
                case "left":
                    move(0, -1, maze);
                    break;
                case "right":
                    move(0, 1, maze);
                    break;
                default:
                    System.out.println("Invalid command! Please enter up, down, left, or right.");
            }
        }
    }

    public int[] getPosition() {
        return position;
    }

    public char getSymbol() {
        return symbol;
    }

}
