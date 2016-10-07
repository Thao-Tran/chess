/**
 * The Knight represents a knight chess piece object. It is used to display a knight on the
 * chessboard and move the piece around the board.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class Knight {
    private ChessGame game;
    private String owner;
    private ChessLocation location;
    private boolean invalidMove;
    private String piece;

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
        this.owner = owner;
        this.location = initialLocation;
        this.game = game;
        this.invalidMove = false;
        this.piece = "K";
        game.getBoard().placePieceAt(this, initialLocation);
    }

    /**
     * The moveTo method moves the chess piece if the inputted row and column are within bounds [0, 7] and is a valid
     * move.
     *
     * @param newLocation ChessLocation object that represents the new location that the chess piece will be placed at
     */
    public void moveTo(ChessLocation newLocation) {
        int deltaRow = Math.abs(newLocation.getRow() - location.getRow());
        int deltaCol = Math.abs(newLocation.getCol() - location.getCol());
        if (newLocation.getRow() > 7 || newLocation.getRow() < 0 || newLocation.getCol() > 7 || newLocation.getCol() < 0) {
            setInvalidMove(true);
        } else {
            if (deltaRow == 1 && deltaCol == 2 || deltaRow == 2 && deltaCol == 1) {
                game.getBoard().placePieceAt(this, newLocation);
            } else {
                setInvalidMove(true);
            }
        }
    }

    /**
     * The getLocation method is an accessor for the location of the chess piece.
     *
     * @return A ChessLocation object representing the current location of the chess piece
     */
    public ChessLocation getLocation() {
        return location;
    }

    /**
     * The getLocation method is a mutator for the location of the chess piece.
     *
     * @param location A
     */
    public void setLocation(ChessLocation location) {
        this.location = location;
    }

    /**
     * The getLocation method is an accessor for the location of the chess piece.
     *
     * @return A ChessLocation object representing the current location of the chess piece
     */
    public String getOwner() {
        return owner;
    }

    /**
     * The getLocation method is an accessor for the location of the chess piece.
     *
     * @return A ChessLocation object representing the current location of the chess piece
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * The getLocation method is an accessor for the location of the chess piece.
     *
     * @return A ChessLocation object representing the current location of the chess piece
     */
    public ChessGame getGame() {
        return game;
    }

    /**
     * The getLocation method is an accessor for the location of the chess piece.
     *
     * @return A ChessLocation object representing the current location of the chess piece
     */
    public void setGame(ChessGame game) {
        this.game = game;
    }

    /**
     * The getLocation method is an accessor for the location of the chess piece.
     *
     * @return A ChessLocation object representing the current location of the chess piece
     */
    public boolean getInvalidMove() {
        return invalidMove;
    }

    /**
     * The getLocation method is an accessor for the location of the chess piece.
     *
     * @return A ChessLocation object representing the current location of the chess piece
     */
    public void setInvalidMove(boolean invalidMove) {
        this.invalidMove = invalidMove;
    }

    /**
     * The getLocation method is an accessor for the location of the chess piece.
     *
     * @return A ChessLocation object representing the current location of the chess piece
     */
    public String getPiece() {
        return piece;
    }

    /**
     * The getLocation method is an accessor for the location of the chess piece.
     *
     * @return A ChessLocation object representing the current location of the chess piece
     */
    public void setPiece(String piece) {
        this.piece = piece;
    }
}