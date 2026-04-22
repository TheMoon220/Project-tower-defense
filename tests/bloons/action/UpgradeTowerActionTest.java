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
        UpgradeTowerAction action = new UpgradeTowerAction(offlineTower);
        
        assertFalse(action.execute(board));
        assertEquals(initialCredits, Board.PLAYER.getCredit());
        assertEquals(0, offlineTower.getAppliedEvolutions().size());
    }

    @Test 
    public void testExecuteNoMoreEvolutions(){
        UpgradeTowerAction action = new UpgradeTowerAction(testTower);
        for(int i = 0; i < 3; i++){
            assertTrue(action.execute(board));
        }

        assertFalse(action.execute(board));
        assertEquals(3, testTower.getAppliedEvolutions().size());
    }

    @Test
    public void testExecuteNotEnoughCredits(){
        Board.PLAYER.removeCredit(initialCredits - 50);
        UpgradeTowerAction action = new UpgradeTowerAction(testTower);
        assertFalse(action.execute(board));
        assertEquals(0, testTower.getAppliedEvolutions().size());
    }

    @Test
    public void testExecuteWithDifferentTowers(){
        Position BombPos = board.getValidTowerPosition();
        BombTower bombTower = new BombTower(600, 150,Effect.DISTANCE,1800,BombPos,Projectile.BOMB);
        board.addTower(bombTower);
        UpgradeTowerAction bombAction = new UpgradeTowerAction(bombTower);

        assertTrue(bombAction.execute(board));
        assertEquals(1, bombTower.getAppliedEvolutions().size());

        Position sniperPos = board.getValidTowerPosition();
        SniperMonkeyTower sniperTower = new SniperMonkeyTower(500, Effect.IMMEDIAT, 2000, sniperPos, Projectile.POINTEDDART);
        board.addTower(sniperTower);
        UpgradeTowerAction sniperAction = new UpgradeTowerAction(sniperTower);
        assertTrue(sniperAction.execute(board));
        assertEquals(1, sniperTower.getAppliedEvolutions().size());
    }

    @Test
    public void testGetCost(){
        UpgradeTowerAction action = new UpgradeTowerAction(testTower);
        int firstCost = action.getCost();
        assertTrue(firstCost > 0);
        action.execute(board);
        int secondCost = action.getCost();
        assertTrue(secondCost > 0);
        assertNotEquals(firstCost, secondCost);
    }

    @Test 
    public void testGetCostWhenNoMoreEvolutions(){
        UpgradeTowerAction action = new UpgradeTowerAction(testTower);
        while(testTower.getAppliedEvolutions().size() < testTower.getPossibleEvolutions().size()){
            action.execute(board);
        }
        assertEquals(0, action.getCost());
    }

    @Test
    public void testGetDescription(){
        UpgradeTowerAction action = new UpgradeTowerAction(testTower);
        String description = action.getDescription();
        assertTrue(description.contains("Upgrade"));
        assertTrue(description.contains("DartMonkeyTower"));
        assertTrue(description.contains(position.toString()));
    }
}
