/**
 * The Queen class is a subclass of the ChessPiece class and represents a queen chess piece object. It is used
 * initialize the id of the queen and place it on the board. It also determines whether the inputted move is valid or
 * not.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (22.Oct.2016)
 */
public class Queen extends ChessPiece {
    /**
     * The Queen constructor initializes the owner, location, and game variables to the corresponding passed
     * parameters, and invalidMove to false. The constructor also places the object at the initial location on the
     * chessboard.
     *
     * @param owner String representing the name of the owner of the game.
     * @param initialLocation ChessLocation object representing the initial location of the piece.
     * @param game ChessGame object represent the chess game that the piece is for.
     */
    public Queen(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);

        // Set ID of piece to 'Q' if player 1, 'q' if player 2
        if (owner.equals("player1")) {
            setId('Q');
        }
        else {
            setId('q');
        }

        // Place queen at initial location, i.e. (0, 3) or (7, 3).
        game.getBoard().placePieceAt(this, initialLocation);
    }


    @Override
    public boolean checkValidMove(int deltaRow, int deltaCol) {
        // Return true if horizontal, vertical or diagonal movement.
        return deltaRow == 0 || deltaCol == 0 || Math.abs(deltaRow) == Math.abs(deltaCol);
    }
}
