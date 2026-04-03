package bloons.tower.projectileTower;
import bloons.tower.projectileTower.*;
import bloons.utils.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import bloons.Position;
import bloons.balloon.Balloon;

public class DartMonkeyTowerTest  extends ProjectileTowerTest{
    

    @Test
      public void aTTackBalloonDarkMonkeyTower() throws InterruptedException{
        t1.attackBallon(bal1,System.currentTimeMillis());
        Thread.sleep((long) t1.getCadence());
        t1.attackBallon(bal1,System.currentTimeMillis());
        assertEquals(0,bal1.getHealth());

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
    public void evolutRangeTheDartMokeyTower(){
        double rangeBefore= t1.getRange();
        t1.putEvolutions();
        assertEquals(rangeBefore*1.25, t1.getRange());
        

  }
    @Test
    public void dartMonkeyRemoveEvolutionRestoresCadence() {
        double cadenceBefore = t1.getCadence();
        t1.putEvolutions(); // 1
       t1.putEvolutions(); // 2 : cadence
        t1.removeEvolution();
        assertEquals(cadenceBefore, t1.getCadence());
    }
    }
