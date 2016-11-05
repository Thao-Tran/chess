import static java.lang.Math.abs;

/**
 * The Knight class is a subclass of the ChessPiece class and represents a knight chess piece object. It is used
 * initialize the id of the knight and place it on the board. It also determines whether the inputted move is valid or
 * not.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class Knight extends ChessPiece{
    /**
     * The Knight constructor initializes the owner, location, and game variables to the corresponding passed
     * parameters, and invalidMove to false. The constructor also places the object at the initial location on the
     * chessboard.
     *
     * @param owner String representing the name of the owner of the game.
     * @param initialLocation ChessLocation object representing the initial location of the piece.
     * @param game ChessGame object represent the chess game that the piece is for.
     */
    public Knight(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);

        // If player 1, set ID to 'N'
        if (owner.equals("player1")) {
            setId('N');
        }
        else { // If player 2, set ID to 'n'
            setId('n');
        }

        // Place knight at initial location, i.e. (0,1) or (0,6)
        game.getBoard().placePieceAt(this, initialLocation);
    }

    @Override
    public boolean checkValidMove(int deltaRow, int deltaCol) {
        deltaRow = Math.abs(deltaRow);
        deltaCol = Math.abs(deltaCol);

        return (deltaRow == 1 && deltaCol == 2 || deltaRow == 2 && deltaCol == 1);
    }
}