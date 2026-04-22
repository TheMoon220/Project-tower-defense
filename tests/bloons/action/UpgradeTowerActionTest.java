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
import javax.swing.text.Position;

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
}
