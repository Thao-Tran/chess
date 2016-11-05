import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The PawnTest class.
 *
 * @author Thao-Tran Le-Phuong
 * @version 1.0 (02.Nov.2016)
 */
public class PawnTest {
    ChessGame game;
    ChessBoard board;
    ChessLocation location;
    ChessPiece pawn;
    ChessPiece pawn2;

    @Before
    public void setUp() throws Exception {
        game = new ChessGame("player1", "player2");
        board = game.getBoard();
        pawn = board.getPieceAt(new ChessLocation(1, 3));
        pawn2 = board.getPieceAt(new ChessLocation(1, 0));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidFirstMoveToEmptySquare1() {
        location = pawn.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol());
        pawn.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidFirstMoveToEmptySquare2() {
        location = pawn.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 2, location.getCol());
        pawn.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidSecondMoveToEmptySquare() {
        location = pawn.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol());
        pawn.moveTo(newLocation);
        newLocation = new ChessLocation(location.getRow() + 2, location.getCol());
        pawn.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testInvalidSecondMoveToEmptySquare() {
        location = pawn.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol());
        pawn.moveTo(newLocation);
        newLocation = new ChessLocation(location.getRow() + 3, location.getCol());
        pawn.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare_Vertical() {
        location = pawn.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 3, location.getCol());
        pawn.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare_Backwards() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(pawn, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol());
        pawn.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare_Diagonal() {
        location = pawn.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 1);
        pawn.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare_Horizontal() {
        location = pawn.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow(), location.getCol() + 1);
        pawn.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testValidMoveToOccupiedSquare() {
        location = pawn.getLocation();
        board.placePieceAt(pawn2, new ChessLocation(location.getRow() + 1, location.getCol()));
        pawn.moveTo(new ChessLocation(location.getRow() + 1, location.getCol()));
        assert(game.getInvalidMove());
    }
}
