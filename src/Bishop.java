/**
 * The Bishop class is a subclass of the ChessPiece class and represents a bishop chess piece object. It is used
 * initialize the id of the bishop and place it on the board. It also determines whether the inputted move is valid or
 * not.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (22.Oct.2016)
 */
public class Bishop extends ChessPiece{
    /**
     * The Bishop constructor initializes the owner, location, and game variables to the corresponding passed
     * parameters, and the ID of the bishop. The constructor also places the object at the initial location on the
     * chessboard.
     *
     * @param owner String representing the name of the owner of the game.
     * @param initialLocation ChessLocation object representing the initial location of the piece.
     * @param game ChessGame object represent the chess game that the piece is for.
     */
    public Bishop(String owner, ChessLocation initialLocation, ChessGame game) {
        // Call parent constructor.
        super(owner, initialLocation, game);

        // Set ID of the piece to 'B' if player 1, 'b' if player 2.
        if (owner.equals("player1")) {
            setId('B');
        }
        else {
            setId('b');
        }
    }

    @Override
    public boolean checkValidMove(int deltaRow, int deltaCol) {
        // Return true if change in row is the same as change in column, i.e. diagonal movement
        return Math.abs(deltaRow) == Math.abs(deltaCol);
    }
}
