
package bloons.tower;
import bloons.tower.IceTower;
import bloons.tower.Tower ;
import bloons.tower.projectileTower.DartMonkeyTower;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import bloons.Position;
import bloons.balloon.Balloon;
import bloons.utils.Effect;
import bloons.utils.Level;
import bloons.utils.Projectile;


public class TowerTest {
    
private Balloon bal1;
    private Balloon bal2;
    private Balloon bal3;
    private Position pos;
    private Level l1;
    private Level l2;
    private Tower  t1;
    private Tower t2 ;
    private Tower t3 ;
    private List<Balloon> ballons =new ArrayList<>();
    private Position pos1 ;
    private Position pos2 ;
    


    @BeforeEach
     public void Before(){
   
       pos1 = new Position(2, 4);
       pos2 = new Position(2, 0);
       ballons.add(bal1);
       ballons.add(bal2);
       ballons.add(bal3);
       




           
            bal1 = new Balloon(new Position(3, 3),Level.NIV2 );
            bal2 = new Balloon(new Position(2, 0),Level.NIV2 );
            bal3 = new Balloon(new Position(1, 2),Level.NIV2 );

            t1=new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos1, Projectile.DART);
            t2=new IceTower(400,100,Effect.IMMEDIAT,1500,pos2);
            t1.addBalloons(ballons);
       t2.addBalloons(ballons);
       
        }
       @Test 
       
       public void testBalloonInRange(){
        assertTrue(t1.Inrange(bal1));
        assertFalse(t1.Inrange(bal2));
        assertTrue(t2.Inrange(bal2));

       }
       @Test
        public void testCanAttack(){
      assertTrue(t1.canAttack((System.currentTimeMillis())));
      assertTrue(t2.canAttack((System.currentTimeMillis())));
      

     }
     
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
         Thread.sleep((long) t1.getCadence()-200);
        assertFalse(t1.canAttack(System.currentTimeMillis()));

      }
  @Test
       public void aTTackBalloonIceTower() throws InterruptedException{
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

