
package bloons.tower;

import bloons.tower.projectileTower.*;
import bloons.utils.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import bloons.Position;
import bloons.balloon.Balloon;

public abstract class TowerTest {

  protected Balloon bal1;
  protected Balloon bal2;
  protected Balloon bal3;
  protected Position pos;
  protected Tower t1;
  protected Tower t2;
  protected ProjectileTower t3;
  protected Tower t4;
  protected Tower t5;
  protected Tower t6;
   protected Tower t7;
  protected List<Balloon> ballons = new ArrayList<>();
  protected Position pos1;
  protected Position pos2;
  protected Position pos3;
  protected Evolution evo1;
  protected Evolution evo2;
  protected Evolution evo3;
  protected Evolution evo4;

  @BeforeEach
  public void Before() {

    pos1 = new Position(2, 4);
    pos2 = new Position(2, 0);
    pos3 = new Position(0, 0);
    pos = new Position(1, 1);
    bal1 = new Balloon(new Position(3, 3), Level.NIV2);
    bal2 = new Balloon(new Position(2, 0), Level.NIV2);
    bal3 = new Balloon(new Position(1, 2), Level.NIV2);
    ballons.add(bal1);
    ballons.add(bal2);
    ballons.add(bal3);
    evo1 = Evolution.CADANCE;
    evo2 = Evolution.POWER;
    evo3 = Evolution.PROJECTILE;
    evo4 = Evolution.RANGE;
    t1 = new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 100, pos1, Projectile.DART);
    t1.possibleEvolutions.put(evo1,1);
    t2 = new IceTower(400, 100, Effect.IMMEDIAT, 150, pos2);
    t3 = new BombTower(600, 150, Effect.DISTANCE, 180, pos3, Projectile.BOMB);
    t3.possibleEvolutions.put(evo2,1);
    t3.possibleEvolutions.put(evo1,2);
    t3.possibleEvolutions.put(evo3,1);
    t4 = new SniperMonkeyTower(500, Effect.IMMEDIAT, 200, pos2, Projectile.VERYSHARPDART);
    t4.possibleEvolutions.put(evo1,3);
    t4.possibleEvolutions.put(evo2,2);
    t5 = new SuperMonkeyTower(500, 100, Effect.IMMEDIAT, 100, pos3, Projectile.POINTEDDART);
    t5.possibleEvolutions.put(evo3,2);
    t5.possibleEvolutions.put(evo4,1);
    t6 = new TackShooterTower(350, 80, Effect.IMMEDIAT, 120, pos, Projectile.NEEDLE);
    t6.possibleEvolutions.put(evo1,4);
    t6.possibleEvolutions.put(evo2,3);
    t7= new SlowDownTower(500, 100, Effect.IMMEDIAT, 1500, pos);
    t3.addBalloons(ballons);
    t1.addBalloons(ballons);
    t2.addBalloons(ballons);
    t7.addBalloons(ballons);
  }

  @Test
  public void testBalloonInRange() {
    assertTrue(t1.Inrange(bal1));
    assertFalse(t1.Inrange(bal2));
    assertTrue(t2.Inrange(bal2));

  }

  @Test
  public void testCanAttack() {
    assertTrue(t1.canAttack((System.currentTimeMillis())));
    assertTrue(t2.canAttack((System.currentTimeMillis())));

  }

}
