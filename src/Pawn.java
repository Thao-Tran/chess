/**
 * The Pawn class is a subclass of the ChessPiece class and represents a pawn chess piece object. It is used
 * initialize the id of the pawn and place it on the board. It also determines whether the inputted move is valid or
 * not.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (22.Oct.2016)
 */
public class Pawn extends ChessPiece{
    public boolean firstMove;

    /**
     * The Pawn constructor initializes the owner, location, and game variables to the corresponding passed
     * parameters. The constructor also places the object at the initial location on the
     * chessboard.
     *
     * @param owner           String representing the name of the owner of the game.
     * @param initialLocation ChessLocation object representing the initial location of the piece
     * @param game            ChessGame object represent the chess game that the piece is for
     */
    public Pawn(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);

        // Set ID of piece to 'P' if player 1, 'p' if player 2
        if (owner.equals("player1")) {
            setId('P');
        }
        else {
            setId('p');
        }

        // Place queen at initial location, i.e. (1, 0 - 7) or (6, 0 - 7).
        game.getBoard().placePieceAt(this, initialLocation);

        firstMove = true;
    }

    @Override
    public boolean checkValidMove(int deltaRow, int deltaCol) {
        // If it is the first move of the pawn, the pawn can move forward 1 or 2 squares. If not, only one square.

        if (firstMove) {
            return (deltaRow == 1 && deltaCol == 0 || deltaRow == 2 && deltaCol == 0);
        }
        else {
            return (deltaRow == 1 && deltaCol == 0);
        }
    }

    @Override
    public void setFirstMove() {
        if (firstMove) {
            firstMove = false;
        }
    }
}
