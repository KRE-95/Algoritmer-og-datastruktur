import java.util.Scanner;


public class Main extends Chess_board {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give a size for the board: ");
         n = in.nextInt();
        System.out.println("Give a start column: ");
        int col = in.nextInt();
        System.out.println("Give a start row: ");
        int row = in.nextInt();

        solve_Prob(row,col);








    }

}
