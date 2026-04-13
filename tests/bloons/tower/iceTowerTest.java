package bloons.tower;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import bloons.utils.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import bloons.Position;
import bloons.balloon.Balloon;
public class iceTowerTest  extends TowerTest{
    @Test
      public void aTTackBalloonIceTower() throws InterruptedException{
      super.Before();
         t2.attackBallon(bal2,System.currentTimeMillis());
        Thread.sleep((long) t2.getCadence());
        t1.attackBallon(bal2,System.currentTimeMillis());
        assertEquals(0,bal2.getSpeed());

      }
    @Test
      public void CanNotaTTackBalloonIceTower() throws InterruptedException{
         t2.attackBallon(bal2,System.currentTimeMillis());
         Thread.sleep((long) t2.getCadence());
        t2.attackBallon(bal2,System.currentTimeMillis());
       
        
         Thread.sleep((long) t2.getCadence()-100);
        assertFalse(t2.canAttack(System.currentTimeMillis()));

      }

     @Test
      public void testFreezeBalloon() throws InterruptedException{
       t2.attackBallon(bal2,System.currentTimeMillis());
        Thread.sleep((long) t2.getCadence());
        t2.attackBallon(bal2,System.currentTimeMillis());
        Thread.sleep((long) t2.getCadence());
        assertEquals(0,bal2.getSpeed());

      }
}
