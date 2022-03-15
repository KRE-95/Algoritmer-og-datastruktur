
public class Main {
    public static void main(String[] args) {
        char [][] maze = {
                {'.', '.', '.', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
                {'0', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
                {'.', '.', '.', '0', '.', '0', '.', '0', '.', '0'},
                {'.', '0', '0', '0', '.', '.', '.', '0', '.', '0'},
                {'.', '.', '.', '.', '0', '0', '0', '.', '.', '0'},
                {'.', '0', '0', '.', '.', '.', '0', '.', '.', '0'},
                {'.', '.', '.', '0', '0', '.', '0', '0', '.', '.'},
                {'0', '0', '.', '0', '0', '.', '.', '.', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '.', '.', '.'},

        };
        print(maze);

        if (Maze.traverse(maze,0,0)){
            System.out.println();
            System.out.println("________________");
            System.out.println(" Solved the maze. ");
            System.out.println("________________");
        }else {
            System.out.println("Not solved");
        }

    }
    // to get graphical understanding on how to solve the maze - 10 x 10

    private static void print(char[][] maze) {
        System.out.println("-----------------------");
        for(int x = 0; x < 10; x++) { // iterate x coordinate
            System.out.print("| ");  // Just for the board - line.
            for(int y = 0; y < 10; y++) {  // y coordinate
                System.out.print(maze[x][y] + " "); // " JUST FOR SPACE "
            }
            System.out.println("|");
        }
        System.out.println("-----------------------");
        System.out.println();
        System.out.println(" . = Path" + "\n" +
                " 0 = no path/ deadend.");
    }
}
