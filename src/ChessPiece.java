/**
 * The ChessPiece class.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (22.Oct.2016)
 */
public class ChessPiece {
    private ChessGame game;
    private String player;
    private ChessLocation location;
    protected char id;

    public ChessPiece(String owner, ChessLocation initialLocation, ChessGame game) {
        player = owner;
        location = initialLocation;
        this.game = game;
    }

    /**
     * The moveTo method moves the knight if the inputted location is within bounds [0, 7] and is a valid move.
     *
     * @param newLocation ChessLocation object that represents the new location that the chess piece will be placed at
     */
    public void moveTo(ChessLocation newLocation) {
        int deltaRow = Math.abs(newLocation.getRow() - location.getRow());
        int deltaCol = Math.abs(newLocation.getCol() - location.getCol());
        if (newLocation.getRow()<=7 && newLocation.getRow()>=0 && newLocation.getCol()<=7 && newLocation.getCol()>=0) {
            if (checkValidMove(deltaRow, deltaCol) && checkLineOfSight(location, newLocation)) {
                game.setInvalidMove(false);
                game.getBoard().placePieceAt(this, newLocation);
            }
            else {
                game.setInvalidMove(true);
            }
        }
        else {
            game.setInvalidMove(true);
        }
    }

    /**
     * The createShadows method adds shadows at legal moves that are blocked.
     */
    public void createShadows() {}

    /**
     * The checkValidMove method checks whether that inputted change in row and col is valid.
     *
     * @param deltaRow  The change in the row.
     * @param deltaCol  The change in the column.
     * @return  A boolean object that represents whether the inputted move is valid.
     */
    public boolean checkValidMove(int deltaRow, int deltaCol) {
        return true;
    }

    /**
     * The checkLineOfSight method checks whether the destination is blocked.
     *
     * @param start A ChessLocation object that represents the start location of the chess piece.
     * @param end   A ChessLocation object that represents the end location of the chess piece.
     * @return  A boolean object the represents whether the path from the start location to the end location is blocked.
     */
    protected boolean checkLineOfSight(ChessLocation start, ChessLocation end) {
        return true;
    }

    /**
     * The getLocation method is an accessor for the location of the piece.
     *
     * @return A ChessLocation object representing the current location of the piece.
     */
    public ChessLocation getLocation() {
        return location;
    }

    /**
     * The setLocation method is a mutator for the location of the piece.
     *
     * @param location A ChessLocation object representing the desired location of the piece.
     */
    public void setLocation(ChessLocation location) {
        this.location = location;
    }

    /**
     * The getPlayer method is an accessor for the owner of the piece.
     *
     * @return A String of the name of the player.
     */
    public String getPlayer() {
        return player;
    }

    /**
     * The setPlayer method is a mutator for the owner of the piece.
     *
     * @param player A String of the name of the new owner.
     */
    public void setOwner(String player) {
        this.player = player;
    }

    /**
     * The getGame method is an accessor for the game that the piece is currently in.
     *
     * @return A ChessGame object representing the current game.
     */
    public ChessGame getGame() {
        return game;
    }

    /**
     * The setGame method is a mutator for the game that the piece is in.
     *
     * @param game A ChessGame object representing the new game.
     */
    public void setGame(ChessGame game) {
        this.game = game;
    }

    /**
     * The getId method is an accessor for the id of the piece.
     *
     * @return A String of the id for the piece.
     */
    public char getId() {
        return id;
    }

    /**
     * The setId method is a mutator for the id of the piece.
     *
     * @param id A String of the new id for the piece.
     */
    public void setId(char id) {
        this.id = id;
    }
}
