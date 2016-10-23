/**
 * The ChessBoard class represents a chessboard object. It is used to display the chessboard and the store the
 * chess pieces of the chessboard.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class ChessBoard {
    private ChessPiece chessboard[][];
    private boolean shadows[][];
    private static final String H_LINE = "---";
    private static final String V_LINE = "|";
    private static final String IN_USE = " %s ";
    private static final String SPACE = " ";
    private static final String NEWLINE = "\n";

    /**
     * The ChessBoard constructor initializes the chessboard ChessPiece 8x8 array to null.
     */
    public ChessBoard() {
        chessboard = new ChessPiece[8][8];
        shadows = new boolean[8][8];
        resetShadows();
    }

    public ChessPiece getPieceAt(ChessLocation location) {
        return chessboard[location.getRow()][location.getCol()];
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
        return row >= 0 && row <= 7 && col >= 0 && col <= 7 && chessboard[row][col] != null;
    }

    /**
     * The placePieceAt method places the specific chess piece at the specified location.
     *
     * @param piece    A ChessPiece object representing the piece to be moved.
     * @param location  A ChessLocation object representing the desired location of the chess piece.
     */
    public void placePieceAt(ChessPiece piece, ChessLocation location) {
        if (!isPieceAt(location.getRow(), location.getCol())) {
            ChessLocation currentLocation = piece.getLocation();
            removePiece(currentLocation);
            chessboard[location.getRow()][location.getCol()] = piece;
            piece.setLocation(location);
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
     * The isFriendlyPiece method checks if the piece at a location is owned by the same player as the provided piece.
     * @param piece     A ChessPiece object that represents the chess piece being checked.
     * @param location  A ChessLocation object that represents the location of the other chess piece being checked.
     * @return  A boolean object that represents whether the piece at the location is owned by the same player as the
     *          provided piece.
     */
    public boolean isFriendlyPiece(ChessPiece piece, ChessLocation location) {
        if (isPieceAt(location.getRow(), location.getCol())) {
            return piece.getPlayer().equals(chessboard[location.getRow()][location.getCol()].getPlayer());
        }
        else {
            return true;
        }
    }

    /**
     * The setShadow method sets a shadow at the provided location.
     * @param location  A ChessLocation object that represents the location of the shadow.
     */
    public void setShadow(ChessLocation location) {
        shadows[location.getRow()][location.getCol()] = true;
    }

    /**
     * The resetShadow method resets all shadows back to false.
     */
    public void resetShadows() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                shadows[i][j] = false;
            }
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
                        stringBoard += String.format(IN_USE, chessboard[i / 2 - 1][j].getId()) + V_LINE;
                    }
                    else if (shadows[i / 2 - 1][j]) {
                        stringBoard += String.format(IN_USE, 'X') + V_LINE;
                    }
                    else {
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
