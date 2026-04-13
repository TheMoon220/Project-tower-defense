package bloons.tower.projectileTower;
import bloons.utils.*;
import bloons.tower.TowerTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public  abstract class ProjectileTowerTest  extends TowerTest{
      
      @Test
      public void towerCanEvolute(){
        t1.putEvolutions();
        Evolution v= t1.getAppliedEvolutions().pop();
        assertEquals(evo1,v);
      }
    @Test
    public void towerCanEvolute2(){
        t1.applyEvolution(evo1);                     // applique evo1
        t1.getAppliedEvolutions().push(evo1);             // push manuellement
        Evolution v = t1.getAppliedEvolutions().pop();
        assertEquals(evo1, v);
    }
}
