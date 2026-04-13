package bloons.tower.projectileTower;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class SniperMonkeyTowerTest extends ProjectileTowerTest {
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




}
