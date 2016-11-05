/**
 * The Rook class is a subclass of the ChessPiece class and represents a rook chess piece object. It is used
 * initialize the id of the rook and place it on the board. It also determines whether the inputted move is valid or
 * not.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (22.Oct.2016)
 */
public class Rook extends ChessPiece {
    /**
     * The Rook constructor initializes the owner, location, and game variables to the corresponding passed
     * parameters. The constructor also places the object at the initial location on the
     * chessboard.
     *
     * @param owner           String representing the name of the owner of the game.
     * @param initialLocation ChessLocation object representing the initial location of the piece
     * @param game            ChessGame object represent the chess game that the piece is for
     */
    public Rook(String owner, ChessLocation initialLocation, ChessGame game) {
        super(owner, initialLocation, game);

        // If player 1, set ID to 'R'
        if (owner.equals("player1")) {
            setId('R');
        }
        else { // If player 2, set ID to 'r'
            setId('r');
        }

        // Place rook at initial location, i.e. (0,0), (0,7), (7, 0), or (7, 7)
        game.getBoard().placePieceAt(this, initialLocation);
    }


    @Override
    public boolean checkValidMove(int deltaRow, int deltaCol) {
        return deltaRow == 0 || deltaCol == 0;
    }
}
