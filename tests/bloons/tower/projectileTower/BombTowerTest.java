package bloons.tower.projectileTower;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import bloons.utils.Projectile;

public class BombTowerTest extends ProjectileTowerTest {
  @Test
  public void aTTackBalloonReducesHealth() throws InterruptedException {
   int before = bal2.getHealth();
   t3.attackBallon(bal2,System.currentTimeMillis());
   assertTrue(bal2.getHealth()<before);
  }

  @Test
  public void CanNotaTTackImmediatelyAfterAttack() throws InterruptedException {
     long time = System.currentTimeMillis();
    t3.attackBallon(bal2, time);
    assertFalse(t3.canAttack(time));

  }
  @Test
  public void evoluteTheBombTower() {
    Projectile projectileBefore = t3.getProjectil();
    int before = projectileBefore.getNiveauDegat();
    t3.applyEvolution(evoPower);
    int after = t3.getProjectil().getNiveauDegat();
    assertEquals(before + 1, after);
  }

  @Test
  public void bombTowerPutEvolutionsIncreasesCadence() {
    double cadenceBefore = t3.getCadence();
    t3.applyEvolution(evoCadence);
    double cadenceAfter = t3.getCadence();
    assertNotEquals(cadenceBefore, cadenceAfter);

  }

  @Test
  public void bombTowerPowerEvolution() {
    int before = t3.getProjectil().getNiveauDegat();
    t3.applyEvolution(evoPower);
    assertEquals(before + 1, t3.getProjectil().getNiveauDegat());
  }

  @Test
  public void bombTowerRemoveEvolutionRestoresProjectile() {
    // t3.applyEvolution(evoCadence);
    // t3.applyEvolution(evoPower);
    t3.applyEvolution(evoProjectile);
    // t3.applyEvolution(evoRange);
    t3.removeEvolutionEffect(evoProjectile);
    assertEquals(Projectile.BOMB,  t3.getProjectil());
  }
  @Test
  public void bombTowerRemoveEvolutionRestoresCadence() {
    double before= t3.getCadence();
    t3.applyEvolution(evoCadence);
    t3.removeEvolutionEffect(evoCadence);
    assertEquals(before,  t3.getCadence());
  }
  @Test
  public void bombTowerCadenceEvolutionAndRemoval() {
      double before = t3.getCadence();
      t3.applyEvolution(evoCadence);
      assertEquals(before * 1.25, t3.getCadence());
      t3.removeEvolutionEffect(evoCadence);
      assertEquals(before, t3.getCadence());
  }
  
}
