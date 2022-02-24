public class Chess_board {
    // return true if it is right otherwise false ->&&
    static int n ;
    public static  int _Board[][]; // saved

    static boolean _AvailableCell(int x, int y, int solution[][]){     // can move here
        return (x >= 0 && x < n && y >=0 && y < n && solution[x][y] ==-1);
    }

    private static void script() {
        for (int i=0; i< _Board.length -1; i++)
        {
            System.out.println("("+ _Board[i][0] + ", " +  _Board[i][1]+"),("+ _Board[i+1][0] +", "+ _Board[i+1][1]+")");
        }
    }

    public static boolean solve_Prob(int i, int j) {
        int solution[][] = new  int[n][n];
        _Board = new int[n*n][2];
        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++)
                solution[x][y] = - 1;  // the vaule of board is -1

        // give the knight pattern
        int x_Axe [] = {2,2,1,-1,-2,-2,-1,1};
        int y_Axe [] = {1,-1,-2,2,-1,1,2,2};

        // start from the cell the knight is
        solution[i][j] = 0;
        _Board[0][0] = j;
        _Board [0] [1] = i;
        if (!find_Solution(i,j,1,solution,x_Axe,y_Axe)){
            System.out.println("No solution");
            return false;
        } else {
            script();
        }
        return true;
    }

    private static boolean find_Solution(int x, int y, int steps, int solution[][], int[] x_axe, int[] y_axe) {
        int X,  Y;
        if (steps == n*n)
            return true;
        // move from current position (p) - tries every cell 8 that are Available.
        for (int p = 0; p < 8; p++){
            X = x + x_axe[p];
            Y = y + y_axe[p];
            if (_AvailableCell(X,Y,solution)){ // have solution
                solution[X][Y] = steps;
                if (find_Solution(X,Y, steps+1, solution,x_axe,y_axe)){ // find
                    _Board[steps][0]= Y;
                    _Board[steps][1]= X;
                    return true;
                }else
                    solution[X][Y] = -1;
            }
        }
        return false;
    }



}
