package bloons.tower;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.*;
public class slowDownTowerTest extends TowerTest{
    @Test
      public void aTTackBalloonslowDown() throws InterruptedException{
         t7.attackBallon(bal2,System.currentTimeMillis());
        Thread.sleep((long) t7.getCadence());
        t7.attackBallon(bal2,System.currentTimeMillis());
        assertEquals(0.5,bal2.getSpeed());
      }
    @Test
      public void CanNotaTTackBalloon() throws InterruptedException{
         t7.attackBallon(bal2,System.currentTimeMillis());
         Thread.sleep((long) t7.getCadence());
        t7.attackBallon(bal2,System.currentTimeMillis());
         Thread.sleep((long) t7.getCadence()-100);
        assertFalse(t7.canAttack(System.currentTimeMillis()));

      }

    


}

