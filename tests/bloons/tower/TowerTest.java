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
   
       pos1 = new Position(rand.nextInt(6), rand.nextInt(6));
       pos2 = new Position(rand.nextInt(6), rand.nextInt(6));

           
            bal1 = new Balloon(new Position(3, 3),Level.NIV1 );
            bal2 = new Balloon(new Position(0, 0),Level.NIV2 );
            bal3 = new Balloon(new Position(1, 2),Level.NIV2 );

            t1=new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos1, Projectile.DART);
            t2=new IceTower(400,100,Effect.IMMEDIAT,1500,pos2);
        }
       @Test 
       
       public void testBalloonInRange(){
        AssertTrue(t1.Inrange(bal3));
        AssertFalse(t1.Inrange(bal2));
        AssertTrue(t3.Inrange(bal2));




       }
      public void testCanAttack(){
      AssertTrue(t1.canAttack((System.nanoTime())));
      

      }
      public void aTTackBalloonDarkMonkeyTower(){
        t1.attack(bal1);
        Thread.wait(t1.getCadence());
        t1.attackBallon(bal1,System.nanoTime());
        AssertEquals(0,bal1.getHealth());

      }
       public void aTTackBalloonIceTower(){
        t1.attack(bal1);
        Thread.wait(t1.getCadence());
        t1.attackBallon(bal1,System.nanoTime());
        AssertEquals(0,bal1.getHealth());

      }

      public void testFreezeBalloon(){

      }
    
    }

