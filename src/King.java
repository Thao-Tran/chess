/**
 * The King class is a subclass of the ChessPiece class and represents a king chess piece object. It is used
 * initialize the id of the king and place it on the board. It also determines whether the inputted move is valid or
 * not.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (22.Oct.2016)
 */
public class King extends ChessPiece {
    /**
     * The King constructor initializes the owner, location, and game variables to the corresponding passed
     * parameters, and the ID of the King. The constructor also places the object at the initial location on the
     * chessboard.
     *
     * @param owner           String representing the name of the owner of the game.
     * @param initialLocation ChessLocation object representing the initial location of the piece.
     * @param game            ChessGame object represent the chess game that the piece is for.
     */
    public King(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);

        // Set ID of piece to 'K' if player 1, 'k' if player 2
        if (owner.equals("player1")) {
            setId('K');
        }
        else {
            setId('k');
        }
    }

    @Override
    public boolean checkValidMove(int deltaRow, int deltaCol) {
        deltaRow = Math.abs(deltaRow);
        deltaCol = Math.abs(deltaCol);
        return (deltaRow == 1 && deltaCol == 1 || deltaRow == 1 && deltaCol == 0|| deltaRow == 0 && deltaCol == 1);
    }


}
