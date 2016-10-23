/**
 * The Knight represents a knight chess piece object. It is used to display a knight on the
 * chessboard and move the piece around the board.
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
     * @param owner           String representing the name of the owner of the game.
     * @param initialLocation ChessLocation object representing the initial location of the piece
     * @param game            ChessGame object represent the chess game that the piece is for
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

    /**
     * The checkValidMove method checks whether that inputted change in row and col is valid.
     *
     * @param deltaRow  The change in the row.
     * @param deltaCol  The change in the column.
     * @return  A boolean object that represents whether the inputted move is valid.
     */
    @Override
    public boolean checkValidMove(int deltaRow, int deltaCol) {
        if (deltaRow == 1 && deltaCol == 2 || deltaRow == 2 && deltaCol == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}