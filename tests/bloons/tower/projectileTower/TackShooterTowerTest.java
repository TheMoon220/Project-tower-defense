package bloons.tower.projectileTower;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TackShooterTowerTest extends ProjectileTowerTest {
    @Test
    public void evoluteRange() {
        double rangeBefore = t6.getRange();
        t6.applyEvolution(evoRange);
        assertEquals(rangeBefore * 1.20, t6.getRange());
    }

    @Test
    public void RemoveEvolutionRestoresCadence() {
        double cadenceBefore = t6.getCadence();
        t6.applyEvolution(evoCadence);
        t6.removeEvolutionEffect(evoCadence);
        assertEquals(cadenceBefore, t6.getCadence());
    }

    @Test
    public void RangeEvolutionAndRemoval() {
        double before = t6.getRange();
        t6.applyEvolution(evoRange);
        assertEquals(before * 1.20, t6.getRange());
        t6.removeEvolutionEffect(evoRange);
        assertEquals(before, t6.getRange());
    }
}
