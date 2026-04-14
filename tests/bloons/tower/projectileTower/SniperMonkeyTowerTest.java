package bloons.tower.projectileTower;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import bloons.tower.projectileTower.*;
import bloons.tower.*;
import bloons.utils.Evolution;
import bloons.utils.Projectile;
public class SniperMonkeyTowerTest extends ProjectileTowerTest {
    @Test 
        public void evoluteCadenceSniperMonkeyTower(){
          double cadenceBefore = t4.getCadence();
          t4.applyEvolution(evoCadence);;
          assertEquals(cadenceBefore * 1.25, t4.getCadence());
        }
    @Test
        public void sniperMonkeyRremoveEvolutionRestoresCadence() {
        double cadenceBefore = t4.getCadence();
        t4.applyEvolution(evoCadence); // 1
        t4.removeEvolutionEffect(evoCadence);
        assertEquals(cadenceBefore, t4.getCadence());
    }
    @Test 
        public void evolutePowerSniperMonkeyTowerPower(){
            int oldPuissance = t4.getProjectil().getNiveauDegat();
            double cadenceBefore = t4.getCadence();
            t4.applyEvolution(evoPower);
            assertEquals(cadenceBefore, t4.getCadence());
            assertEquals(oldPuissance+2,t4.getProjectil().getNiveauDegat());
        }



}
