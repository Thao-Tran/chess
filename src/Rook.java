/**
 * The Rook class.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (22.Oct.2016)
 */
public class Rook extends ChessPiece {
    /**
     * The Knight constructor initializes the owner, location, and game variables to the corresponding passed
     * parameters, and invalidMove to false. The constructor also places the object at the initial location on the
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

        // Place knight at initial location, i.e. (0,0) or (0,7)
        game.getBoard().placePieceAt(this, initialLocation);
    }

    /**
     * The createShadows method adds shadows at legal moves that are blocked.
     */
    @Override
    public void createShadows() {
        for (int i = 0; i < 8; i++) {
            if (!checkLineOfSight(getLocation(), new ChessLocation(getLocation().getRow(), i))) {
                getGame().getBoard().setShadow(new ChessLocation(getLocation().getRow(), i));
            }

            if (!checkLineOfSight(getLocation(), new ChessLocation(i, getLocation().getCol()))) {
                getGame().getBoard().setShadow(new ChessLocation(i, getLocation().getCol()));
            }
        }
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
        return deltaRow == 0 || deltaCol == 0;
    }

    /**
     * The checkLineOfSight method checks whether the destination is blocked.
     *
     * @param start A ChessLocation object that represents the start location of the chess piece.
     * @param end   A ChessLocation object that represents the end location of the chess piece.
     * @return  A boolean object the represents whether the path from the start location to the end location is blocked.
     */
    @Override
    protected boolean checkLineOfSight(ChessLocation start, ChessLocation end) {
        int startCol = start.getCol();
        int endCol = end.getCol();
        int startRow = start.getRow();
        int endRow = end.getRow();
        int inc = 1; // inc holds the value that the for loop will increment by

        // Checks if there's a piece at the destination
        if (getGame().getBoard().isPieceAt(endRow, endCol)) {
            // Checks if that piece is friendly or an enemy
            if (getGame().getBoard().isFriendlyPiece(this, end)) {
                return false;
            }
        }
        else {
            // Decrement if the piece starts at a row or column greater than the destination
            if (startCol > endCol || startRow > endRow) {
                inc = -1;
            }

            // Check if there are pieces blocking the piece in the direction of movement
            if (startRow == endRow) { // Horizontal movement
                for (int i = startCol + inc; i != endCol; i += inc) {
                    if (getGame().getBoard().isPieceAt(startRow, i)) {
                        return false;
                    }
                }
            }
            else if (startCol == endCol) { // Vertical movement
                for (int i = startRow + inc; i != endRow; i += inc) {
                    if (getGame().getBoard().isPieceAt(i, startCol)) {
                        return false;
                    }
                }
            }
            else { // Illegal movement
                return false;
            }
        }

        return true;
    }
}
