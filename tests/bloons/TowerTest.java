package bloons;
import bloons.tower.IceTower;
import bloons.tower.Tower;
import bloons.tower.projectileTower.DartMonkeyTower;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import bloons.balloon.Balloon;
import bloons.utils.Level;


public class TowerTest {
    
private Balloon bal1;
    private Balloon bal2;
    private Position pos;
    private Level l1;
    private Level l2;
    private Tower  t1;
    private Tower t2 ;
    private List<Balloon> ballons =new ArrayList<>();
    


    @BeforeEach
     public void Before(){
            pos = new Position(0, 2);
           
            bal1 = new Balloon(pos,Level.NIV1 );
            bal2 = new Balloon(pos,Level.NIV2 );
            t1=new DartMonkeyTower(0, 0, null, 0, pos, null);
            t2=new IceTower(0, 0, null, 0, pos);
        }
       @Test 
       
       public void testBalloonInRange(){

       }
      public void testCanAttack(){

      }
      public void aTTackBalloonDarkMonkeyTower(){

      }
       public void aTTackBalloonIceTower(){

      }

      public void testFreezeBalloon(){

      }
    }

