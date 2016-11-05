import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The QueenTest class.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (02.Nov.2016)
 */
public class QueenTest {
    ChessGame game;
    ChessBoard board;
    ChessLocation location;
    ChessPiece queen;
    ChessPiece king;

    @Before
    public void setUp() throws Exception {
        game = new ChessGame("player1", "player2");
        board = game.getBoard();
        queen = board.getPieceAt(new ChessLocation(0, 3));
        king = board.getPieceAt(new ChessLocation(0, 4));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidDiagonalMoveToEmptySquare1() {
        location = queen.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 1);
        queen.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidDiagonalMoveToEmptySquare2() {
        location = queen.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 4, location.getCol() + 4);
        queen.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidVerticalMoveToEmptySquare() {
        location = queen.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol());
        queen.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidHorizontalMoveToEmptySquare() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(queen, location);
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() - 1);
        queen.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(queen, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 2, location.getCol() + 1);
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testBlockedHorizontalPath() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(queen, location);
        board.placePieceAt(king, new ChessLocation(location.getRow(), location.getCol() + 1));
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() + 3);
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testBlockedVerticalPath() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(queen, location);
        board.placePieceAt(king, new ChessLocation(location.getRow() + 1, location.getCol()));
        ChessLocation newLocation = new ChessLocation(location.getRow() + 3, location.getCol());
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testBlockedDiagonalPath() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(queen, location);
        board.placePieceAt(king, new ChessLocation(location.getRow() + 1, location.getCol() + 1));
        ChessLocation newLocation = new ChessLocation(location.getRow() + 3, location.getCol() + 3);
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testValidHorizontalMoveToOccupiedSquare() {
        location = queen.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() + 1);
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testValidVerticalMoveToOccupiedSquare() {
        location = new ChessLocation(1, 2);
        board.placePieceAt(queen, location);
        location = queen.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol());
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testValidDiagonalMoveToOccupiedSquare() {
        location = new ChessLocation(1, 2);
        board.placePieceAt(queen, location);
        location = queen.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol() - 1);
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testOutOfBoundsVerticalMove() {
        location = queen.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol());
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testOutOfBoundsDiagonalMove() {
        location = queen.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol() - 1);
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testOutOfBoundsHorizontalMove() {
        location = new ChessLocation(1, 0);
        board.placePieceAt(queen, location);
        location = queen.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() - 1);
        queen.moveTo(newLocation);
        assert(game.getInvalidMove());
    }
}
