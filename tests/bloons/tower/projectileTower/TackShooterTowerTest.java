package bloons.tower.projectileTower;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class TackShooterTowerTest  extends ProjectileTowerTest {
    @Test 
    public void evolutecadance (){
           double rangeBefore = t6.getRange();
           t6.applyEvolution(evoRange);
           assertEquals(rangeBefore * 1.50, t6.getRange());
        }
    @Test
    public void RemoveEvolutionRestoresCadence() {
        double cadenceBefore =t6.getCadence();
        t6.applyEvolution(evoCadence);
        t6.removeEvolutionEffect(evoCadence);
        assertEquals(cadenceBefore, t6.getCadence());
    }
    @Test
    public void CadenceEvolutionAndRemoval() {
      double before = t6.getCadence();
      t6.applyEvolution(evoCadence);
      assertEquals(before * 1.25, t6.getCadence());
      t6.removeEvolutionEffect(evoCadence);
      assertEquals(before, t6.getCadence());
  }
}
