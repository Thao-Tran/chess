/**
 * The ChessGame class represents a chess game. It is used to begin a chess game.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class ChessGame {
    private ChessBoard board;
    private String player1;
    private String player2;
    private boolean invalidMove;

    /**
     * The ChessGame constructor initializes the chessboard and chess pieces.
     *
     * @param player1 A String of the name of player 1.
     * @param player2 A String of the name of player 2.
     */
    public ChessGame(String player1, String player2) {
        board = new ChessBoard();
        this.player1 = player1;
        this.player2 = player2;
        new Knight(player1, new ChessLocation(0, 1), this);
        new Knight(player1, new ChessLocation(0, 6), this);
        new Rook(player1, new ChessLocation(0, 0), this);
        new Rook(player1, new ChessLocation(0, 7), this);

        invalidMove = false;
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
     * The getPlayer1 method is an accessor for the name of player 1.
     *
     * @return A String object representing the name of player 1.
     */
    public String getPlayer1() {
        return player1;
    }

    /**
     * The setPlayer1 method is a mutator for the name of player 1.
     *
     * @param player1    A String object that represents the new name of player 1.
     */
    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    /**
     * The getPlayer2 method is an accessor for the name of player 2.
     *
     * @return A String object representing the name of player 2.
     */
    public String getPlayer2() {
        return player2;
    }

    /**
     * The setPlayer2 method is a mutator for the name of player 2.
     *
     * @param player2    A String object that represents the new name of player 2.
     */
    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    /**
     * The getInvalidMove method is an accessor for the validity of the desired move.
     *
     * @return A boolean stating true if the move was invalid and false if not.
     */
    public boolean getInvalidMove() {
        return invalidMove;
    }

    /**
     * The setInvalidMove method is a mutator for the validity of the desired move.
     *
     * @param invalidMove A boolean stating true if the move was invalid and false if not.
     */
    public void setInvalidMove(boolean invalidMove) {
        this.invalidMove = invalidMove;
    }
}
