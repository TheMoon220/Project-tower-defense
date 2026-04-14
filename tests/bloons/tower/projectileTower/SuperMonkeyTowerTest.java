package bloons.tower.projectileTower;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class SuperMonkeyTowerTest  extends ProjectileTowerTest{
    @Test 
        public void evoluteRangeSuperMonkeyTower(){
           double rangeBefore = t5.getRange();
           t5.applyEvolution(evoRange);
           assertEquals(rangeBefore * 1.50, t5.getRange());
        }
    @Test 
        public void evoluteCadenceSuperMonkeyTower(){
           double cadenceBefore =t5.getCadence();
           t5.applyEvolution(evoCadence);
           assertEquals(cadenceBefore*3, t5.getCadence());
        }
    @Test
    public void superMonkeyRemoveEvolutionRestoresCadence() {
        double cadenceBefore =t5.getCadence();
        t5.applyEvolution(evoCadence);
        t5.removeEvolutionEffect(evoCadence);
        assertEquals(cadenceBefore, t5.getCadence());
    }
    @Test
    public void superMonkeyRemoveEvolutionRestoresRange() {
        double rangeBefore =t5.getRange();
        t5.applyEvolution(evoRange);
        t5.removeEvolutionEffect(evoRange);
        assertEquals(rangeBefore, t5.getRange());
    }
    @Test
    public void CadenceEvolutionAndRemoval() {
      double before = t5.getCadence();
      t5.applyEvolution(evoCadence);
      assertEquals(before *3, t5.getCadence());
      t5.removeEvolutionEffect(evoCadence);
      assertEquals(before, t5.getCadence());
  }
}
