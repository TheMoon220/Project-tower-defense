package bloons.action;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import bloons.board.Board;
import bloons.board.ClassicalBoard;
import bloons.Position;
import bloons.tower.*;
import bloons.tower.projectileTower.*;
import bloons.utils.*;

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
}
