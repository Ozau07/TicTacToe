import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
                                                                                                                   
            // Make empty board
            String[][] board = new String[3][3];
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    board[r][c] = " ";
                }
            }
           
            int round = 1;
            boolean gameOver = false;

            while (!gameOver) {

                // 1. Print Round #
                System.out.println("Round " + round + ":");

                // 2. Print Board
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        System.out.print("[" + board[r][c] + "]");
                    }
                    System.out.println();
                }

                // 3. Ask which symbol they want to place
                System.out.println("Enter your symbol (X or O): ");
                String player = scan.nextLine();

                // make sure symbol is valid
                while (!player.equals("X") && !player.equals("O")) {
                    System.out.println("Invalid symbol. Enter X or O:");
                    player = scan.nextLine();
                }

                // 4. Ask for move
                System.out.println("Enter your move (row,col):");
                String move = scan.nextLine();

                // 5. Convert "x,y" into ints
                int comma = move.indexOf(',');
                int row = Integer.parseInt(move.substring(0, comma));
                int col = Integer.parseInt(move.substring(comma + 1));

                // 6. Validate move
                while (row < 0 || row > 2 || col < 0 || col > 2 || !board[row][col].equals(" ")) {
                    System.out.println("Invalid move. Try again:");
                    move = scan.nextLine();
                    comma = move.indexOf(',');
                    row = Integer.parseInt(move.substring(0, comma));
                    col = Integer.parseInt(move.substring(comma + 1));
                }

                // 7. Place symbol
                board[row][col] = player;

                // 8. Check win
                if (hasWon(board, player)) {
                    System.out.println(player + " wins!");
                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            System.out.print("[" + board[r][c] + "]");
                        }
                        System.out.println();
                    }
                    gameOver = true;
                }

                round++;
            }

            // 9. Ask to continue
            System.out.println("Continue? (Y/N)");
            String again = scan.nextLine();

            if (!again.equalsIgnoreCase("Y")) {
                playing = false;
            }
        }

        System.out.println("Game ended.");
    }

    // Win Check
    public static boolean hasWon(String[][] b, String p) {

        // rows
        for (int r = 0; r < 3; r++) {
            if (b[r][0].equals(p) && b[r][1].equals(p) && b[r][2].equals(p)) return true;
        }

        // cols
        for (int c = 0; c < 3; c++) {
            if (b[0][c].equals(p) && b[1][c].equals(p) && b[2][c].equals(p)) return true;
        }

        // diagonals
        if (b[0][0].equals(p) && b[1][1].equals(p) && b[2][2].equals(p)) return true;
        if (b[0][2].equals(p) && b[1][1].equals(p) && b[2][0].equals(p)) return true;

        return false;
    }
}