package bloons.action;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import bloons.Position;
import bloons.board.ClassicalBoard;
import bloons.board.Board;
import bloons.tower.Tower;
import bloons.tower.projectileTower.DartMonkeyTower;
import bloons.tower.projectileTower.BombTower;
import bloons.tower.projectileTower.SniperMonkeyTower;
import bloons.utils.Effect;
import bloons.utils.Projectile;
import bloons.utils.Evolution;

public class UpgradeTowerActionTest {
    private ClassicalBoard board;
    private Position position;
    private DartMonkeyTower testTower;
    private int initialCredits;

    @BeforeEach
    public void setUp(){
        board = new ClassicalBoard(10, 10);
        position = board.getValidTowerPosition();
        testTower = new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, position, Projectile.DART);
        initialCredits = Board.PLAYER.getCredit();
        board.addTower(testTower);
    }

    @AfterEach
    public void tearDown(){
        Board.PLAYER.removeCredit(Board.PLAYER.getCredit());
        Board.PLAYER.addCredit(2500);
    }

    @Test 
    public void testExecuteSuccess(){
        UpgradeTowerAction action = new UpgradeTowerAction(testTower);

        assertTrue(action.execute(board));
        assertEquals(1, testTower.getAppliedEvolutions().size());
        assertTrue(Board.PLAYER.getCredit() < initialCredits);
    }

    @Test 
    public void testExecuteMultipleEvolutions(){
        UpgradeTowerAction action = new UpgradeTowerAction(testTower);
        assertTrue(action.execute(board));
        int creditsAfterFirst = Board.PLAYER.getCredit();
        assertEquals(1, testTower.getAppliedEvolutions().size());
        assertTrue(action.execute(board));
        assertEquals(2, testTower.getAppliedEvolutions().size());
        assertTrue(Board.PLAYER.getCredit() < creditsAfterFirst);
    }

    @Test
    public void testExecuteTowerNotOnBoard(){
        Position otherPos = new Position(5,5);
        DartMonkeyTower offlineTower = new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, otherPos, Projectile.DART);
        Upgraaaaaaaaaaaaaaaaaaaaaaaaaaaade
    }
}
