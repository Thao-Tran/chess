/**
 * The ChessLocation class represents the location of the chess piece on the chessboard.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class ChessLocation {
    private int row, col;

    /**
     * The ChessLocation constructor intializes the row and column values of the location.
     *
     * @param row   The specified row as an integer.
     * @param col   The specified column as an integer.
     */
    public ChessLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * The getRow method is an accessor for the row of the location.
     *
     * @return The row as an integer.
     */
    public int getRow() {
        return row;
    }

    /**
     * The setRow method is a mutator for the row of the location.
     *
     * @param row   The new row as an integer.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * The getCol method is an accessor for the column of the location.
     *
     * @return The column as an integer.
     */
    public int getCol() {
        return col;
    }

    /**
     * The setCol method is a mutator for the column of the location.
     *
     * @param col   The new column as an integer.
     */
    public void setCol(int col) {
        this.col = col;
    }
}
