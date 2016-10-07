/**
 * The ChessGame class represents a chess game. It is used to begin a chess game.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class ChessGame {
    private ChessBoard board;
    private Knight knight;

    public ChessGame() {
        board = new ChessBoard();
        knight = new Knight("W", new ChessLocation(7, 1), this);
    }

    public ChessBoard getBoard() {
        return board;
    }

    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }
}
