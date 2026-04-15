package bloons.tower.projectileTower;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperMonkeyTowerTest  extends ProjectileTowerTest{

    @Test 
        public void evoluteRangeSuperMonkeyTower(){
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
