package bloons.action;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import bloons.*;
import bloons.action.*;
import bloons.board.Board;
import bloons.board.ClassicalBoard;
import bloons.utils.*;
import bloons.tower.*;
import bloons.tower.projectileTower.*;

public class DowngradeTowerActionTest {
    private ClassicalBoard board;
    private Position position;
    private DartMonkeyTower testTower;
    private int initialCredits;

    @BeforeEach
    public void setUp(){
        board = new ClassicalBoard(10, 10);
        position = board.getValidTowerPosition();
        testTower = new DartMonkeyTower(200, 100,Effect.IMMEDIAT, 1000, position, Projectile.DART);
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
        UpgradeTowerAction upgrade = new UpgradeTowerAction(testTower);
        upgrade.execute(board);

        int creditsAfterUpgrade = Board.PLAYER.getCredit();
        assertEquals(1, testTower.getAppliedEvolutions().size());
        DowngradeTowerAction downgrade = new DowngradeTowerAction(testTower);
        assertTrue(downgrade.execute(board));
        assertEquals(0, testTower.getAppliedEvolutions().size());
        assertTrue(Board.PLAYER.getCredit() > creditsAfterUpgrade);
    }
}
