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
import bloons.Position;

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

    @Test 
    public void testExecuteMultipleDowngrades(){
        UpgradeTowerAction upgrade = new UpgradeTowerAction(testTower);
        upgrade.execute(board);
        upgrade.execute(board);

        assertEquals(2, testTower.getAppliedEvolutions().size());
        int creditsAfterTwoUpgrades = Board.PLAYER.getCredit();
        DowngradeTowerAction downgrade = new DowngradeTowerAction(testTower);
        assertTrue(downgrade.execute(board));
        assertEquals(1, testTower.getAppliedEvolutions().size());
        assertTrue(downgrade.execute(board));
        assertEquals(0, testTower.getAppliedEvolutions().size());
        assertTrue(Board.PLAYER.getCredit() > creditsAfterTwoUpgrades);
    }

    @Test 
    public void testExecuteTowerNotOnBoard(){
        Position otherPos = new Position(5,5);
        DartMonkeyTower offlineTower = new DartMonkeyTower(200,100,Effect.IMMEDIAT,1000,otherPos,Projectile.DART);
        DowngradeTowerAction downgrade = new DowngradeTowerAction(offlineTower);
        assertFalse(downgrade.execute(board));
        assertEquals(initialCredits, Board.PLAYER.getCredit());
    }

    @Test
    public void testExecuteNoEvolutionsToRemove(){
        DowngradeTowerAction downgrade = new DowngradeTowerAction(testTower);
        assertFalse(downgrade.execute(board));
        assertEquals(initialCredits, Board.PLAYER.getCredit());
        assertEquals(0, testTower.getAppliedEvolutions().size());
    }

    @Test 
    public void testExecuteRefundAmount(){
        UpgradeTowerAction upgrade = new UpgradeTowerAction(testTower);
        upgrade.execute(board);
        int creditsAfterUpgrade = Board.PLAYER.getCredit();
        int expectedRefund = (int) (testTower.getPossibleEvolutions().values().iterator().next() * 0.5);
        DowngradeTowerAction downgrade = new DowngradeTowerAction(testTower);
        downgrade.execute(board);
        int expectedCredits = creditsAfterUpgrade + expectedRefund;
        assertEquals(expectedCredits, Board.PLAYER.getCredit());
    }

    @Test 
    public void testExecuteWithDifferentTowers(){
        Position bombPos = board.getValidTowerPosition();
        BombTower bombTower = new BombTower(600,150,Effect.DISTANCE,1800,bombPos,Projectile.BOMB);
        board.addTower(bombTower);
        UpgradeTowerAction bombUpgrade = new UpgradeTowerAction(bombTower);
        bombUpgrade.execute(board);
        assertEquals(1, bombTower.getAppliedEvolutions().size());
        DowngradeTowerAction bombDowngrade = new DowngradeTowerAction(bombTower);
        assertTrue(bombDowngrade.execute(board));
        assertEquals(0, bombTower.getAppliedEvolutions().size());
    }

    @Test 
    public void testGetCost(){
        DowngradeTowerAction downgrade = new DowngradeTowerAction(testTower);
        assertEquals(0, downgrade.getCost());
    }
}
