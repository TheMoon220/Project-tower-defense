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
        assertEquals(initialCredits - 200, Board.PLAYER.getCredit());
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

    @Test
    public void testExecuteWithDifferentTowers(){
        Position pos1 = ((ClassicalBoard) board).getValidTowerPosition();
        Tower iceTower = new IceTower(400, 100, Effect.IMMEDIAT, 1500, pos1);
        BuyTowerAction action1 = new BuyTowerAction(iceTower, pos1);

        assertTrue(action1.execute(board));
        assertTrue(board.getAllTowers().contains(iceTower));

        Position pos2 = ((ClassicalBoard) board).getValidTowerPosition();
        Tower bombTower = new BombTower(600,150,Effect.DISTANCE,1800,pos2,Projectile.BOMB);
        BuyTowerAction action2 = new BuyTowerAction(bombTower, pos2);

        assertTrue(action2.execute(board));
        assertTrue(board.getAllTowers().contains(bombTower));

        int expectedCredits = initialCredits - 400 - 600;
        assertEquals(expectedCredits, Board.PLAYER.getCredit());
    }

    @Test 
    public void testGetCost(){
        BuyTowerAction action = new BuyTowerAction(testTower, validPosition);
        assertEquals(200, action.getCost());

        Tower expensiveTower = new BombTower(600, 150, Effect.DISTANCE, 1800, validPosition, Projectile.BOMB);
        BuyTowerAction expensiveAction = new BuyTowerAction(expensiveTower, validPosition);
        assertEquals(600, expensiveAction.getCost());
    }

    @Test
    public void testGetDescription(){
        BuyTowerAction action = new BuyTowerAction(testTower, validPosition);
        String description = action.getDescription();

        assertTrue(description.contains("DartMonkeyTower"));
        assertTrue(description.contains("cost: 200"));
        assertTrue(description.contains(validPosition.toString()));
    }

    @Test 
    public void testExecuteMultipleTowers(){
        Position pos1 = ((ClassicalBoard) board).getValidTowerPosition();
        Position pos2 = ((ClassicalBoard) board).getValidTowerPosition();
        Position pos3 = ((ClassicalBoard) board).getValidTowerPosition();

        Tower tower1 = new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos1, Projectile.DART);
        Tower tower2 = new IceTower(400, 100, Effect.IMMEDIAT, 1500, pos2);
        Tower tower3 = new BombTower(600, 150, Effect.DISTANCE, 1800, pos3, Projectile.BOMB);

        BuyTowerAction action1 = new BuyTowerAction(tower1, pos1);
        BuyTowerAction action2 = new BuyTowerAction(tower2, pos2);
        BuyTowerAction action3 = new BuyTowerAction(tower3, pos3);

        assertTrue(action1.execute(board));
        assertTrue(action2.execute(board));
        assertTrue(action3.execute(board));
        assertEquals(3, board.getAllTowers().size());
        assertEquals(initialCredits - 200 - 400 - 600, Board.PLAYER.getCredit());
    }
}
