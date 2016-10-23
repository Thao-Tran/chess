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
        Scanner reader = new Scanner(System.in); // Initialize scanner to read inputs
        String input;
        String[] inputCoords;
        int[] srcCoords;
        int[] destCoords;
        ChessLocation srcLocation;
        ChessLocation destLocation;
        ChessPiece piece;

        // Begin chess game

        System.out.println("This is chess.");
        ChessGame game = new ChessGame("player1", "player2");

        // Continue until user quits
        while (!quit) {
            // Display chess board and if the previous move was invalid
            System.out.println("\n\n\n" + game.getBoard());
            if (game.getInvalidMove()) {
                System.out.println("Invalid values inputted.");
                game.setInvalidMove(false);
            }

            // Ask user if they want to move or quit
            System.out.println("Would you like to 'move' or 'quit'?");
            input = reader.nextLine();

            if (input.equals("quit")) {
                quit = true;
            }
            else {
                System.out.println("\n\n\n" + game.getBoard());
                // Get new location of knight or "quit" from user
                System.out.println("Input the position of the piece you would like to move. Example: 'A 1'");
                input = reader.nextLine();

                inputCoords = input.split(" ");
                srcCoords = convertCoordinate(game, inputCoords);

                if (srcCoords != null) {
                    if (game.getBoard().isPieceAt(srcCoords[0], srcCoords[1])) {
                        srcLocation = new ChessLocation(srcCoords[0], srcCoords[1]);
                        piece = game.getBoard().getPieceAt(srcLocation);
                        piece.createShadows();
                        // Display chess board
                        System.out.println("\n\n\n" + game.getBoard());
                        System.out.println("Input the destination of the piece or 'cancel' the move.");
                        input = reader.nextLine();
                        inputCoords = input.split(" ");

                        if (input.equals("cancel")) {
                        } else {
                            destCoords = convertCoordinate(game, inputCoords);

                            if (destCoords != null) {
                                // If move wasn't invalid, move the knight to the location
                                if (!game.getInvalidMove()) {
                                    destLocation = new ChessLocation(destCoords[0], destCoords[1]);
                                    game.getBoard().getPieceAt(srcLocation).moveTo(destLocation);
                                }
                            } else {
                                game.setInvalidMove(true);
                            }
                        }
                    } else {
                        game.setInvalidMove(true);
                    }
                } else {
                    game.setInvalidMove(true);
                }
            }

            game.getBoard().resetShadows();
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

    /**
     * The convertCoordinate method converts a string representation of the coordinates to integers.
     * @param game
     * @param inputCoords
     * @return
     */
    private static int[] convertCoordinate(ChessGame game, String[] inputCoords) {
        int[] coords;
        if (inputCoords.length == 2) {
            // If the inputted row isn't an integer and the column is
            if (!isInt(inputCoords[0]) && isInt(inputCoords[1])) {
                // Convert row character to ASCII and column number to integer
                int row = (int) inputCoords[0].charAt(0);
                int col = Integer.parseInt(inputCoords[1]);

                // If the row inputted is within bounds [A, H] or [a, h], convert to [0, 7], if not, invalid move
                if (row >= 65 && row <= 72) {
                    row -= 65;
                } else if (row >= 97 && row <= 104) {
                    row -= 97;
                } else {
                    game.setInvalidMove(true);
                }

                coords = new int[]{row, col};

                return coords;
            }
        }

        return null;
    }
}