package bloons.tower.projectileTower;

import bloons.tower.projectileTower.*;
import bloons.utils.*;
import bloons.tower.TowerTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import bloons.Position;
import bloons.balloon.*;

public  abstract class ProjectileTowerTest  extends TowerTest{
      
      @Test
      public void towerCanEvolute(){
        t1.putEvolutions();
        Evolution v= t1.appliedEvolutions.pop();
        assertEquals(evo1,v);
      }
    @Test
    public void towerCanEvolute2(){
        t1.applyEvolution(evo1);                     // applique evo1
        t1.appliedEvolutions.push(evo1);             // push manuellement
        Evolution v = t1.appliedEvolutions.pop();
        assertEquals(evo1, v);
    }
}
