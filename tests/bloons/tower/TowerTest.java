 
package bloons.tower;
import bloons.tower.projectileTower.*;
import bloons.utils.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import bloons.Position;
import bloons.balloon.Balloon;

public class TowerTest {
    
private Balloon bal1;
    private Balloon bal2;
    private Balloon bal3;
    private Position pos;
    private Tower t1;
    private Tower t2 ;
    private ProjectileTower t3 ;
    private Tower  t4 ;
    private Tower   t5 ;
    private Tower  t6;
    private List<Balloon> ballons =new ArrayList<>();
    private Position pos1 ;
    private Position pos2 ;
    private Position pos3;
    private Evolution evo1;
    private Evolution evo2;
    private Evolution evo3;
    private Evolution evo4;

    
    @BeforeEach
     public void Before(){
   
      pos1 = new Position(2, 4);
      pos2 = new Position(2, 0);
      pos3= new Position(0, 0);
      pos  = new Position(1, 1);
      bal1 = new Balloon(new Position(3, 3),Level.NIV2 );
      bal2 = new Balloon(new Position(2, 0),Level.NIV2 );
      bal3 = new Balloon(new Position(1, 2),Level.NIV2 );
      ballons.add(bal1);
      ballons.add(bal2);
      ballons.add(bal3);
      evo1= Evolution.CADANCE;
      evo2= Evolution.POWER;
      evo3= Evolution.PROJECTILE;
      evo4= Evolution.RANGE;
      t1=new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 100, pos1, Projectile.DART);
      t1.possibleEvolutions.add(evo1);
      t2=new IceTower(400,100,Effect.IMMEDIAT,150,pos2);
      t3= new BombTower(600, 150, Effect.DISTANCE, 180, pos3,Projectile.BOMB);
      t3.possibleEvolutions.add(evo2);
      t3.possibleEvolutions.add(evo1);
      t3.possibleEvolutions.add(evo3);
      t4= new SniperMonkeyTower(500, Effect.IMMEDIAT, 200, pos2,Projectile.VERYSHARPDART );
      t4.possibleEvolutions.add(evo1);
      t4.possibleEvolutions.add(evo2);
      t5= new SuperMonkeyTower(500, 100, Effect.IMMEDIAT, 100, pos3, Projectile.POINTEDDART);
      t5.possibleEvolutions.add(evo3);
      t5.possibleEvolutions.add(evo4);
      t6= new TackShooterTower(350, 80, Effect.IMMEDIAT, 120, pos, Projectile.NEEDLE);
      t6.possibleEvolutions.add(evo1);
      t6.possibleEvolutions.add(evo2);
      t3.addBalloons(ballons);
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

    
   
   
     
 
      
}

