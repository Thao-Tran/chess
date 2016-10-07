import java.util.Scanner;

/**
 * The PlayGame class is the main class of the project. It is used to display a chess game and receive commands from and
 * send messages to the user.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class PlayGame {

    /**
     * The main method allows a user to play the chess game.
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean quit = false;

        // Get user's name and begin chess game
        Scanner reader = new Scanner(System.in);
        System.out.println("This is chess. What's your name?");
        ChessGame game = new ChessGame(reader.nextLine());

        // Continue until user quits
        while (!quit) {

            // Display chess board and if the previous move was invalid
            System.out.println("\n\n\n" + game.getBoard());
            if (game.getKnight().getInvalidMove()) {
                System.out.println("Invalid values inputted.");
                game.getKnight().setInvalidMove(false);
            }

            // Get new location of knight or "quit" from user
            System.out.println("Input new knight position as 'row column'.\nIf you would like to quit, enter 'quit'.");
            String command = reader.nextLine();

            if (command.equals("quit")) { // Quits game
                quit = true;
            }
            else {
                String[] coords = command.split(" ");
                if (coords.length == 2) {
                    // If the inputted row isn't an integer and the column is
                    if (!isInt(coords[0]) && isInt(coords[1])) {
                        // Convert row character to ASCII and column number to integer
                        int row = (int) coords[0].charAt(0);
                        int col = Integer.parseInt(coords[1]);

                        // If the row inputted is within bounds [A, H] or [a, h], convert to [0, 7], if not, invalid move
                        if (row >= 65 && row <= 72) {
                            row -= 65;
                        } else if (row >= 97 && row <= 104) {
                            row -= 97;
                        } else {
                            game.getKnight().setInvalidMove(true);
                        }

                        // If move wasn't invalid, move the knight to the location
                        if (!game.getKnight().getInvalidMove()) {
                            ChessLocation location = new ChessLocation(row, col);
                            game.getKnight().moveTo(location);
                        }
                    } else { // Invalid move
                        game.getKnight().setInvalidMove(true);
                    }
                }
                else {
                    game.getKnight().setInvalidMove(true);
                }
            }
        }
    }

    /**
     * The isInt method checks whether the given String can be converted to an integer
     *
     * @param   str   String that is being checked.
     * @return  A boolean stating true if the given string is an integer and false if not.
     */
    private static boolean isInt(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}