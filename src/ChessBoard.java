/**
 * The ChessBoard class represents a chessboard object. It is used to display the chessboard and the store the
 * chess pieces of the chessboard.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class ChessBoard {
    private Knight chessboard[][];
    private static final String H_LINE = "---";
    private static final String V_LINE = "|";
    private static final String IN_USE = " %s ";
    private static final String SPACE = " ";
    private static final String NEWLINE = "\n";

    /**
     * The ChessBoard constructor initializes the chessboard Knight 8x8 array to null.
     */
    public ChessBoard() {
        chessboard = new Knight[8][8];
    }

    /**
     * The isPieceAt method checks if there is a chess piece as the specified location.
     *
     * @param row   An integer of the specified row.
     * @param col   An integer of the specified column.
     * @return  A boolean stating true if a chess piece is at the specified location and false if not.
     */
    public boolean isPieceAt(int row, int col){

        // If the inputted rows and columns are within the boundaries
        if (row >= 0 && row <= 7 && col >= 0 && col <= 7 && chessboard[row][col] != null) {
            // Return whether the piece at the location is the same piece as the specified piece or not
            return true;
        }
        else { // If they are not
            return false;
        }
    }

    /**
     * The placePieceAt method places the specific chess piece at the specified location.
     *
     * @param knight    A Knight object representing the knight to be moved.
     * @param location  A ChessLocation object representing the desired location of the chess piece.
     */
    public void placePieceAt(Knight knight, ChessLocation location) {
        if (!isPieceAt(location.getRow(), location.getCol())) {
            ChessLocation currentLocation = knight.getLocation();
            removePiece(currentLocation);
            chessboard[location.getRow()][location.getCol()] = knight;
            knight.setLocation(location);
        }
    }

    /**
     * The removePiece method removes the chess piece at the specified location.
     *
     * @param location  A ChessLocation object representing the location of the piece to be removed.
     */
    public void removePiece(ChessLocation location) {
        if (isPieceAt(location.getRow(), location.getCol())) {
            chessboard[location.getRow()][location.getCol()] = null;
        }
    }

    /**
     * The toString method displays the chessboard.
     *
     * @return A string formatted to display the chessboard like this:
     *           0   1   2   3   4   5   6   7
                --- --- --- --- --- --- --- ---
             A |   |   |   |   |   |   |   |   |
                --- --- --- --- --- --- --- ---
             B |   |   |   |   |   |   |   |   |
                --- --- --- --- --- --- --- ---
             C |   |   |   |   |   |   |   |   |
                --- --- --- --- --- --- --- ---
             D |   |   |   |   |   |   |   |   |
                --- --- --- --- --- --- --- ---
             E |   |   |   |   |   |   |   |   |
                --- --- --- --- --- --- --- ---
             F |   |   |   |   |   |   |   |   |
                --- --- --- --- --- --- --- ---
             G |   |   |   |   |   |   |   |   |
                --- --- --- --- --- --- --- ---
             H |   |   |   |   |   |   |   |   |
                --- --- --- --- --- --- --- ---
     */
    public String toString() {
        //stringBoard starts with four spaces.
        String stringBoard = "    ";

        // Loops through rows
        for (int i = 0; i < 18; i++) {
            // Start every odd numbered row with three spaces
            if (i % 2 != 0) {
                stringBoard += "   ";
            }
            // Start every even numbered row with the row letter and the first vertical line
            else if (i % 2 == 0 && i != 0) {
                stringBoard += String.format(IN_USE, (char) ((i / 2) + 64)) + V_LINE;
            }

            // Loops through columns
            for (int j = 0; j < 8; j++) {
                // Add the column numbers if it's the first row
                if (i == 0) {
                    stringBoard += String.format(IN_USE, j) + SPACE;
                }
                // Add a space and a horizontal line if it's an odd numbered row
                else if (i % 2 != 0) {
                    stringBoard += SPACE + H_LINE;
                }
                // Add either an empty space if there isn't a piece there or the piece if there is, and a vertical line
                else {
                    if (chessboard[i / 2 - 1][j] != null) {
                        stringBoard += String.format(IN_USE, chessboard[i / 2 - 1][j].getPiece()) + V_LINE;
                    } else {
                        stringBoard += "   " + V_LINE;
                    }
                }
            }

            // Add a newline at the end of every row
            stringBoard += NEWLINE;
        }
        
        return stringBoard;
    }
}
