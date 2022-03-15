public class Maze {

    // make a method for the valid spot - Recursion
    public static boolean isValidSpot(char[][] maze ,int r, int c){ // row and column
        if (r >= 0 && r < 10 && c >=0 && c < 10){  // greater or = too (>= 0 ), ( < ) less then , && AND/T/F.
            return maze [r][c] == '.'; // if they are dot, then it is valid path.

        }
        return false; // continue to check if it is true/ if not false.
    }
       public static boolean traverse (char[][] maze, int r, int c){
        // validfy if it is a valid spot
           if (isValidSpot(maze,r,c)){
               // reach end of the maze
               if (r == 9 && c == 9){    // last colum is 9 x 9 row
                   return true;
               }
               maze[r][c] = '*'; // have tried the spot/ or been there

               // continue checking

               // up = r-1
               boolean returnValue = traverse(maze, r-1,c);
               // down
               if (!returnValue) { // if not up then check for down -> r+1
                   returnValue = traverse(maze,r+1,c);
               }
               // left
               if (!returnValue) { // if not up or down then check for left -> c-1
                   returnValue = traverse(maze,r,c-1);
               }
               // right
               if (!returnValue) { // if not up or down or left then check for right -> c+1
                   returnValue = traverse(maze, r, c + 1);
               }
               return returnValue;
           }
           return false; // if not valid then false.
       }
}
