import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The ChessTest class tests the moveTo() method of the Knight class.
 *
 * @author  Thao-Tran Le-Phuong
 * @version 1.0 (05.Oct.2016)
 */

public class ChessTest {
    ChessGame game;
    Knight knight;
    ChessBoard board;
    ChessLocation location;

    @Before
    public void setUp() throws Exception {
        game = new ChessGame("Thao");
        knight = game.getKnight();
        board = game.getBoard();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testValidMove1() {
        // Test up 2, right 1.
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 2, location.getCol() + 1);
        knight.moveTo(newLocation);
        location = knight.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testValidMove2() {
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 2, location.getCol() - 1);
        knight.moveTo(newLocation);
        location = knight.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testValidMove3() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 2, location.getCol() + 1);
        knight.moveTo(newLocation);
        location = knight.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testValidMove4() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 2, location.getCol() - 1);
        knight.moveTo(newLocation);
        location = knight.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testValidMove5() {
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol() + 2);
        knight.moveTo(newLocation);
        location = knight.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testValidMove6() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol() - 2);
        knight.moveTo(newLocation);
        location = knight.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testValidMove7() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() + 2);
        knight.moveTo(newLocation);
        location = knight.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testValidMove8() {
        location = new ChessLocation(4, 4);
        board.placePieceAt(knight, location);
        ChessLocation newLocation = new ChessLocation(location.getRow() + 1, location.getCol() - 2);
        knight.moveTo(newLocation);
        location = knight.getLocation();
        assert(location.getRow() == newLocation.getRow() && location.getCol() == newLocation.getCol());
    }

    @Test
    public void testInvalidMove1() {
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 2, location.getCol() + 2);
        knight.moveTo(newLocation);
        assert(knight.getInvalidMove());
    }

    @Test
    public void testInvalidMove2() {
        location = knight.getLocation();
        ChessLocation setLocation = new ChessLocation(7, 0);
        ChessLocation newLocation = new ChessLocation(9, 1);

        board.placePieceAt(knight, setLocation);
        knight.moveTo(newLocation);
        assert(knight.getInvalidMove());
    }

    @Test
    public void testInvalidMove3() {
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() - 1, location.getCol() + 4);
        knight.moveTo(newLocation);
        assert(knight.getInvalidMove());
    }

    @Test
    public void testInvalidMove4() {
        location = knight.getLocation();
        ChessLocation newLocation = new ChessLocation(location.getRow() + 10, location.getCol() - 10);
        knight.moveTo(newLocation);
        assert(knight.getInvalidMove());
    }


}