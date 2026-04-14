package bloons.tower.projectileTower;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.*;
import bloons.utils.Projectile;

public class BombTowerTest extends ProjectileTowerTest{
     @Test
      public void evoluteTheBombTower() {
        Projectile projectileDegatBefore= t3.getProjectil();
        int beforeNiveauDegat= projectileDegatBefore.getNiveauDegat();
        t3.applyEvolution(evo1);;
        Projectile projectileDegatafter= t3.getProjectil();
        int  afterNiveauDegat= projectileDegatafter.getNiveauDegat();
        assertEquals(beforeNiveauDegat+1, afterNiveauDegat);
        //assertEquals(rangeBefore * 1.50, t3.getRange());
       
  }
        @Test
      public void bombTowerPutEvolutionsIncreasesCadence() {
        double cadenceBefore = t3.getCadence();
         Projectile projectileDegatBefore= t3.getProjectil();
        int beforeNiveauDegat= projectileDegatBefore.getNiveauDegat();
        t3.putEvolutions();
        Projectile projectileDegatafter= t3.getProjectil();
        int  afterNiveauDegat= projectileDegatafter.getNiveauDegat();
        Projectile projectileBefore= t3.getProjectil();
        assertEquals(beforeNiveauDegat+1, afterNiveauDegat);
        t3.putEvolutions();
        assertEquals(cadenceBefore * 1.25, t3.getCadence());
        t3.putEvolutions();
        Projectile projectileAfter= t3.getProjectil();
        assertNotEquals( projectileAfter,projectileBefore);
        assertEquals(Projectile.EXTRABOMB, projectileAfter);
    }  
    
    @Test
    public void bombTowerRemoveEvolutionRestoresProjectile() {
        t3.putEvolutions(); // index 1
        t3.putEvolutions(); // index 2
        t3.putEvolutions(); // index 3
        t3.putEvolutions();
        t3.removeEvolution();
        assertEquals(Projectile.BOMB,((ProjectileTower) t3).getProjectil());
    }
     @Test
      public void aTTackBalloonBombTower() throws InterruptedException{
         t3.attackBallon(bal2,System.currentTimeMillis());
        t3.attackBallon(bal2,System.currentTimeMillis());
        assertEquals(0,bal2.getSpeed());
      }
    @Test
      public void CanNotaTTackBalloonBombTower() throws InterruptedException{
         t3.attackBallon(bal2,System.currentTimeMillis());
         Thread.sleep((long) t2.getCadence());
        t3.attackBallon(bal2,System.currentTimeMillis());
         Thread.sleep((long) t2.getCadence()-100);
        assertFalse(t2.canAttack(System.currentTimeMillis()));

      }
}
