import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The KnightTest class tests the moveTo() method of the Knight class.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class KnightTest {
    ChessGame game;
    ChessBoard board;
    ChessLocation location;
    ChessPiece knight;
    int initialRow;
    int initialCol;

    @Before
    public void setUp() throws Exception {
        game = new ChessGame("player1", "player2");
        board = game.getBoard();
        initialRow = 0;
        initialCol = 1;
        knight = board.getPieceAt(new ChessLocation(initialRow, initialCol));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidMoveToEmptySquare1() {
        // Test up 2, right 1.
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 2, location.getCol() + 1);
        knight.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidMoveToEmptySquare2() {
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 2, location.getCol() - 1);
        knight.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidMoveToEmptySquare3() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() - 2, location.getCol() - 1);
        knight.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidMoveToEmptySquare5() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 2);
        knight.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidMoveToEmptySquare6() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 2);
        knight.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidMoveToEmptySquare7() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol() - 2);
        knight.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidMoveToEmptySquare8() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 2);
        knight.moveTo(newLocation);
        assert(!game.getInvalidMove());
    }

    @Test
    public void testValidMoveToOccupiedSquare() {
        location = new ChessLocation(2, 1);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() - 2, location.getCol() + 1);
        knight.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare1() {
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 2, location.getCol() + 2);
        knight.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare2() {
        location = knight.getLocation();
        ChessLocation setLocation = new ChessLocation(7, 0);
        ChessLocation newLocation = new ChessLocation(9, 1);

        board.placePieceAt(knight, setLocation);
        knight.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare3() {
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol() + 4);
        knight.moveTo(newLocation);
        assert(game.getInvalidMove());
    }

    @Test
    public void testInvalidMoveToEmptySquare4() {
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 10, location.getCol() - 10);
        knight.moveTo(newLocation);
        assert(game.getInvalidMove());
    }


}