/**
 * The ChessGame class represents a chess game. It is used to begin a chess game.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class ChessGame {
    private ChessBoard board;
    private Knight knight;

    /**
     * The ChessGame constructor initializes the chessboard and the knight piece.
     *
     * @param owner A String of the name of the owner of the knight.
     */
    public ChessGame(String owner) {
        board = new ChessBoard();
        knight = new Knight(owner, new ChessLocation(7, 1), this);
    }

    /**
     * The getBoard method is an accessor for the chessboard of the game.
     *
     * @return A ChessBoard object that represents the current state of the chessboard.
     */
    public ChessBoard getBoard() {
        return board;
    }

    /**
     * The setBoard method is a mutator for the chessboard of the game.
     *
     * @param board A ChessBoard object that represents the new chessboard.
     */
    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    /**
     * The getKnight method is an accessor for the knight of the current game.
     *
     * @return A Knight object representing the knight of the current game.
     */
    public Knight getKnight() {
        return knight;
    }

    /**
     * The setKnight method is a mutator for the knight of the current game.
     *
     * @param knight    A Knight object that represents the new knight of the game.
     */
    public void setKnight(Knight knight) {
        this.knight = knight;
    }
}
