import java.util.Scanner;

/**
 * The PlayGame class is the main class of the project. It is used to display a chess game and receive commands from and
 * send messages to the user.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class PlayGame {
    public static void main(String[] args) {
        boolean quit = false;
        ChessGame game = new ChessGame();

        while (!quit) {
            System.out.println("This is chess.\n");
            System.out.println(game.getBoard());
            if (game.getKnight().getInvalidMove()) {
                System.out.println("Invalid values inputted.");
                game.getKnight().setInvalidMove(false);
            }

            Scanner reader = new Scanner(System.in);
            System.out.println("Input new knight position as 'row column'.\nIf you would like to quit, enter 'quit'.");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                quit = true;
            }
            else {
                String[] coords = command.split(" ");
                if (!isInt(coords[0]) && isInt(coords[1])) {
                    int row = (int) coords[0].charAt(0);
                    int col = Integer.parseInt(coords[1]);

                    if (row >= 65 && row <= 72) {
                        row -= 65;
                    }
                    else if (row >= 97 && row <= 104) {
                        row -= 97;
                    }
                    else {
                        game.getKnight().setInvalidMove(true);
                    }

                    if (!game.getKnight().getInvalidMove()) {
                        ChessLocation location = new ChessLocation(row, col);
                        game.getKnight().moveTo(location);
                    }
                }
                else {
                    game.getKnight().setInvalidMove(true);
                }
            }
        }
    }

    public static boolean isInt(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}