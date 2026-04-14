package bloons.tower.projectileTower;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DartMonkeyTowerTest  extends ProjectileTowerTest{
    @Test
      public void aTTackBalloonDarkMonkeyTower() throws InterruptedException{
        int before = bal1.getHealth();
        t1.attackBallon(bal1, System.currentTimeMillis());
        assertTrue(bal1.getHealth() < before);
      }


     @Test
    public void CanNotaTTackBalloonDarkMonkeyTower() throws InterruptedException{
        t1.attackBallon(bal1,System.currentTimeMillis());
         Thread.sleep((long) t1.getCadence());
        t1.attackBallon(bal1,System.currentTimeMillis());
        assertEquals(0,bal1.getHealth());
         Thread.sleep((long) t1.getCadence()-100);
        assertFalse(t1.canAttack(System.currentTimeMillis()));

      }
    @Test
    public void canAttackAfterCadence() throws InterruptedException {
        long now = System.currentTimeMillis();
        t1.attackBallon(bal1, now);
        long later = now + (long) t1.getCadence();
        assertTrue(t1.canAttack(later));
    }
    @Test 
    public void evolutRangeTheDartMokeyTower(){
        double rangeBefore= t1.getRange();
        t1.applyEvolution(evoRange);
        assertEquals(rangeBefore*1.25, t1.getRange());
        

  }
    @Test
    public void dartMonkeyRemoveEvolutionRestoresCadence() {
        double cadenceBefore = t1.getCadence();
        t1.applyEvolution(evoCadence);
        t1.removeEvolutionEffect(evoCadence);
        assertEquals(cadenceBefore, t1.getCadence());
    }
    }
