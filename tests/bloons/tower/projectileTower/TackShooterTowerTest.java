package bloons.tower.projectileTower;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class TackShooterTowerTest  extends ProjectileTowerTest {
      @Test 
        public void evolutecadance (){
           double rangeBefore = t5.getRange();
           t5.applyEvolution(evoRange);
           assertEquals(rangeBefore * 1.50, t5.getRange());
        }
    @Test
    public void superMonkeyRemoveEvolutionRestoresCadence() {
        double cadenceBefore =t5.getCadence();
        t5.applyEvolution(evoCadence);
        t5.removeEvolutionEffect(evoCadence);
        assertEquals(cadenceBefore, t5.getCadence());
    }
}
