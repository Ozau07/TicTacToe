import java.util.Scanner;

public class TICTACTOE {    
    public static void printBoard(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {                
                    
                    if (grid[row][col] == 0){
                        System.out.print("[ ]");}
                    else if (grid[row][col] == 1){
                        System.out.print("[" + "X" + "]");
                    }
                    else {
                        System.out.print("[" + "O" + "]");
                    }
            }            
            System.out.println();
            
        }
        
    }

    
    public static boolean checkWin(int[][] g) {
        for (int i = 0; i < 3; i++) {
            if (g[i][0] == 1 && g[i][1] == 1 && g[i][2] == 1){ 
            return true;  } 
            if (g[0][i] == 1 && g[1][i] == 1 && g[2][i] == 1) {
            return true;   }
        }
        
        if (g[0][0] == 1 && g[1][1] == 1 && g[2][2] == 1) {
            return true;}
        if (g[0][2] == 1 && g[1][1] == 1 && g[2][0] == 1) {
            return true;}
        
        return false;
    }
    public static boolean checkWin2(int[][] g){
        for (int i = 0; i < 3; i++) {
            if (g[i][0] == -1 && g[i][1] == -1 && g[i][2] == -1){ 
            return true;  } 
            if (g[0][i] == -1 && g[1][i] == -1 && g[2][i] == -1) {
            return true;   }
        }
        if (g[0][0] == -1 && g[1][1] == -1 && g[2][2] == -1) {
            return true;}
        if (g[0][2] == -1 && g[1][1] == -1 && g[2][0] == -1) {
            return true;}
        return false;
    }

    public static boolean boardFull(int[][] g) {
        for (int r = 0; r < 3; r++)
            for(int c = 0; c < 3; c++)
                if (g[r][c] == 0){
                    return false;}
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        printBoard(grid);
        Scanner in = new Scanner(System.in);
        int player1 = 1;
        while (true) {
            String input = in.nextLine();
            
            String input1 = input.substring(0,1);
            int Erow = Integer.parseInt(input1);
            
            String input2 = input.substring(2);
            int Ecol = Integer.parseInt(input2);
            
            

            grid[Erow][Ecol] = player1;
                        
            printBoard(grid);

            
            if (checkWin(grid)) {
                System.out.println("Player1wins!");
                break;
                }
            if (checkWin2(grid)) {
                System.out.println("Player2wins!");
                break;
                }

            
            if (boardFull(grid)) {
                System.out.println("draw");
                break;
                }
            System.out.print("Next move pls ");
            player1 = player1*(-1);
        }
    }
}
