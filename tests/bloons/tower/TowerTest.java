 
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
    private ProjectileTower  t1;
    private Tower t2 ;
    private Tower t3 ;
    private Tower  t4 ;
    private Tower   t5 ;
    private Tower  t6;
    private List<Balloon> ballons =new ArrayList<>();
    private Position pos1 ;
    private Position pos2 ;
    private Position pos3;
    


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
   
      t1=new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos1, Projectile.DART);
      t2=new IceTower(400,100,Effect.IMMEDIAT,1500,pos2);
      t3= new BombTower(600, 150, Effect.DISTANCE, 1800, pos3,Projectile.BOMB);
      t4= new SniperMonkeyTower(500, Effect.IMMEDIAT, 2000, pos2,Projectile.VERYSHARPDART );
      t5= new SuperMonkeyTower(500, 100, Effect.IMMEDIAT, 1000, pos3, Projectile.POINTEDDART);
      t6= new TackShooterTower(350, 80, Effect.IMMEDIAT, 1200, pos, Projectile.NEEDLE);
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
      @Test
      public void towerCanEvolute(){
        double rangeBefore = t1.getRange();
        t1.putEvolutions();
        assertTrue(t1.getRange() > rangeBefore);
      }

      @Test
      public void evoluteTheBombTower(){
        double rangeBefore = t3.getRange();
        t3.putEvolutions();
        t3.putEvolutions();
        assertEquals(rangeBefore * 1.50, t3.getRange());
       
  }
      @Test
      public void bombTowerPutEvolutionsIncreasesCadence() {
        double cadenceBefore = t3.getCadence();
        t3.putEvolutions(); 
        t3.putEvolutions();
        t3.putEvolutions();
        assertEquals(cadenceBefore * 1.25, t3.getCadence());
    }  
      @Test
      public void bombTowerPutEvolutionsChangesProjectile() {
          t3.putEvolutions(); // index 1
          t3.putEvolutions(); // index 2
          t3.putEvolutions(); // index 3
          t3.putEvolutions(); // index 4
          assertEquals(Projectile.EXTRABOMB,((ProjectileTower) t3).getProjectil());
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
      @Test 
        public void evoluteCadenceSniperMonkeyTower(){
          double cadenceBefore = t4.getCadence();
          t4.putEvolutions();
          assertEquals(cadenceBefore * 1.25, t4.getCadence());
        }
      @Test
        public void sniperMonkeyRremoveEvolutionRestoresCadence() {
        double cadenceBefore = t4.getCadence();
        t4.putEvolutions(); // 1
        t4.removeEvolution();
        assertEquals(cadenceBefore, t4.getCadence());
    }
 
      @Test 
        public void evoluteRangeSuperMonkeyTower(){
           double rangeBefore = t5.getRange();
           t5.putEvolutions();
           assertEquals(rangeBefore * 1.50, t5.getRange());
        }
        @Test
    public void superMonkeyRemoveEvolutionRestoresCadence() {
        double cadenceBefore =t5.getCadence();
        t5.putEvolutions(); // 1
        t5.putEvolutions(); // 2
        t5.putEvolutions(); // 3
        t5.removeEvolution();
        assertEquals(cadenceBefore, t5.getCadence());
    }

}

