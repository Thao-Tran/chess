import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The BishopTest class.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (24.Oct.2016)
 */
public class BishopTest {
    ChessGame game;
    ChessBoard board;
    ChessLocation location;
    ChessPiece bishop;
    ChessPiece bishop2;

    @Before
    public void setUp() throws Exception {
        game = new ChessGame("player1", "player2");
        board = game.getBoard();
        bishop = board.getPieceAt(new ChessLocation(0, 2));
        bishop2 = board.getPieceAt(new ChessLocation(0, 5));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidDiagonalMoveToEmptySquare1() {
        location = new ChessLocation(2, 2);
        board.placePieceAt(bishop, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 5, location.getCol() + 5);
        bishop.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidDiagonalMoveToEmptySquare2() {
        location = new ChessLocation(2, 2);
        board.placePieceAt(bishop, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 2, location.getCol() - 2);
        bishop.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidDiagonalMoveToEmptySquare3() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(bishop, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol() - 1);
        bishop.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidDiagonalMoveToEmptySquare4() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(bishop, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() - 1);
        bishop.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidDiagonalMoveToOccupiedSquare() {
        location = bishop.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 1);
        bishop.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare1() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(bishop, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 2);
        bishop.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare2() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(bishop, location);
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() + 1);
        bishop.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testBlockedDiagonalPath() {
        location = bishop.getLocation();
        bishop.moveTo(new ChessLocation(location.getRow() + 5, location.getCol() + 5));
        assert(game.getInvalidMove());
    }
}
