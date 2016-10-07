/**
 * The ChessBoard class represents a chessboard object. It is used to store the image of the chessboard and the
 * chess pieces on the chessboard.
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

    public ChessBoard() {
        /*
            ChessBoard constructor
            Sets chessboard 2-D String array to have a layout like this:
                    0   1   2   3   4   5   6   7
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

        // Initialize chessboard to a 2-D 18x18 array of strings
        chessboard = new Knight[8][8];
    }

    public boolean isPieceAt(int row, int col){
        /**
            Returns true if the specified piece is located at the specified row and column.
            Returns false if not.
         */

        // If the inputted rows and columns are within the boundaries
        if (row >= 0 && row <= 7 && col >= 0 && col <= 7 && chessboard[row][col] != null) {
            // Return whether the piece at the location is the same piece as the specified piece or not
            return true;
        }
        else { // If they are not
            return false;
        }
    }

    public void placePieceAt(Knight knight, ChessLocation location) {
        ChessLocation currentLocation = knight.getLocation();
        removePiece(currentLocation);
        chessboard[location.getRow()][location.getCol()] = knight;
        knight.setLocation(location);
    }

    public void removePiece(ChessLocation location) {
        if (isPieceAt(location.getRow(), location.getCol())) {
            chessboard[location.getRow()][location.getCol()] = null;
        }
    }

    public String toString() {
         /*
            ChessBoard constructor
            Sets chessboard 2-D String array to have a layout like this:
                    0   1   2   3   4   5   6   7
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
        String stringBoard = "    ";
        // Loops through rows
        for (int i = 0; i < 18; i++) {
            // If it is the first row or an odd numbered row
            if (i % 2 != 0) {
                stringBoard += "   ";
            }
            // If it is an even numbered row
            else if (i % 2 == 0 && i != 0) {
                stringBoard += String.format(IN_USE, (char) ((i / 2) + 64)) + V_LINE;
            }

            // Loops through columns
            for (int j = 0; j < 8; j++) {
                // If it is the first row
                if (i == 0) {
                    stringBoard += String.format(IN_USE, j) + SPACE;
                }
                // If it is an odd numbered row
                else if (i % 2 != 0) {
                    stringBoard += SPACE + H_LINE;
                }
                else { // If it is an even numbered row
                    if (chessboard[i / 2 - 1][j] != null) {
                        stringBoard += String.format(IN_USE, chessboard[i / 2 - 1][j].getPiece()) + V_LINE;
                    }
                    else {
                        stringBoard += "   " + V_LINE;
                    }
                }
            }

            stringBoard += NEWLINE;
        }

        return stringBoard;
    }
}
