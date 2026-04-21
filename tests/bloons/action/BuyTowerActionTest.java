package bloons.action;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import bloons.board.Board;
import bloons.board.ClassicalBoard;
import bloons.Position;
import bloons.tower.*;
import bloons.tower.projectileTower.*;
import bloons.utils.*;
import bloons.action.*;

public class BuyTowerActionTest {
    private Board board;
    private Position validPosition;
    private Tower testTower;
    private int initialCredits;

    @BeforeEach
    public void setUp(){
        board = new ClassicalBoard(10, 10);
        validPosition = ((ClassicalBoard) board).getValidTowerPosition();
        testTower = new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, validPosition, Projectile.DART);
        initialCredits = Board.PLAYER.getCredit();
    }

    @AfterEach
    public void tearDown(){
        Board.PLAYER.removeCredit(Board.PLAYER.getCredit());
        Board.PLAYER.addCredit(2500);
    }

    @Test 
    public void testExecuteSuccess(){
        BuyTowerAction action = new BuyTowerAction(testTower, validPosition);

        assertTrue(action.execute(board));
        assertEquals(initialCredit - 200, Board.PLAYER.getCredit());
        assertTrue(board.getAllTowers().contains(testTower));
    }

    @Test
    public void testExecuteInvalidPositionOutOfBounds(){
        Position invalidPos = new Position(-1, -1);
        BuyTowerAction action = new BuyTowerAction(testTower, invalidPos);

        assertFalse(action.execute(board));
        assertEquals(initialCredits, Board.PLAYER.getCredit());
        assertFalse(board.getAllTowers().contains(testTower));
    }

    @Test
    public void testExecutePositionAlreadyOccupied(){
        BuyTowerAction firstAction = new BuyTowerAction(testTower, validPosition);
        firstAction.execute(board);
        Tower secondTower = new BombTower(600, 150, Effect.DISTANCE, 1800, validPosition, Projectile.BOMB);
        BuyTowerAction secondAction = new BuyTowerAction(secondTower, validPosition);

        assertFalse(secondAction.execute(board));
        assertEquals(initialCredits - 200, Board.PLAYER.getCredit());
    }

    @Test 
    public void testExecuteNotEnoughCredits(){
        Board.PLAYER.removeCredit(initialCredits);
        assertEquals(0, Board.PLAYER.getCredit());

        BuyTowerAction action = new BuyTowerAction(testTower, validPosition);

        assertFalse(action.execute(board));
        assertFalse(board.getAllTowers().contains(testTower));
    }
}
