import java.util.Random;


public class Maze {

    Random random = new Random();
    char[][] maze;
    int[] position;


    public Maze() {
        maze = new char[10][10];
        position = new int[]{0, 0};
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                maze[i][j] = '*';
            }
        }

    }

    public void placeItems(int numberOfItems, char m) {
        for (int i = 0; i < numberOfItems; i++) {
            int x, y;
            do {
                x = random.nextInt(10);
                y = random.nextInt(10);
            } while (maze[x][y] != '*');

            maze[x][y] = m;

        }

    }

    public char getItem(int row, int col) {
        // Return the item at the given position in the maze
        return maze[row][col];
    }



    public void displayMaze() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void updatePosition( Character character,int newRow, int newCol) {
        maze[position[0]][position[1]] = '*'; // Clear current position
        position[0] = newRow;
        position[1] = newCol;
        maze[position[0]][position[1]] = character.getSymbol(); // Update to new position
        character.getPosition()[0] = newRow;
        character.getPosition()[1] = newCol;
    }
}

