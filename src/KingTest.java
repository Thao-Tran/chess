import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The KingTest class.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (01.Nov.2016)
 */
public class KingTest {
    ChessGame game;
    ChessBoard board;
    ChessLocation location;
    ChessPiece king;
    int initialRow;
    int initialCol;

    @Before
    public void setUp() throws Exception {
        game = new ChessGame("player1", "player2");
        board = game.getBoard();
        initialRow = 0;
        initialCol = 4;
        king = board.getPieceAt(new ChessLocation(initialRow, initialCol));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidDiagonalMoveToEmptySquare() {
        location = new ChessLocation(2, 4);
        board.placePieceAt(king, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 1);
        king.moveTo(newLocation);
        location = king.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testInvalidDiagonalMoveToEmptySquare() {
        location = new ChessLocation(2, 4);
        board.placePieceAt(king, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 2, location.getCol() + 2);
        king.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testValidVerticalMoveToEmptySquare() {
        location = new ChessLocation(2, 4);
        board.placePieceAt(king, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol());
        king.moveTo(newLocation);
        location = king.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testInvalidVerticalMoveToEmptySquare() {
        location = new ChessLocation(2, 4);
        board.placePieceAt(king, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 2, location.getCol());
        king.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testValidHorizontalMoveToEmptySquare() {
        location = new ChessLocation(2, 4);
        board.placePieceAt(king, location);
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() - 1);
        king.moveTo(newLocation);
        location = king.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testInvalidHorizontalMoveToEmptySquare() {
        // Test diagonal 1.
        location = new ChessLocation(2, 4);
        board.placePieceAt(king, location);
        location = king.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() + 2);
        king.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testValidHorizontalMoveToOccupiedSquare() {
        location = king.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() + 1);
        king.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testValidVerticalMoveToOccupiedSquare() {
        location = king.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol());
        king.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testValidDiagonalMoveToOccupiedSquare() {
        location = king.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 1);
        king.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testOutOfBoundsVerticalMove() {
        location = king.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol());
        king.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testOutOfBoundsDiagonalMove() {
        location = king.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol() - 1);
        king.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testOutOfBoundsHorizontalMove() {
        location = new ChessLocation(2, 0);
        board.placePieceAt(king, location);
        location = king.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() - 1);
        king.moveTo(newLocation);
        assert(game.getInvalidMove());
    }
}
