package bloons.tower.projectileTower;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperMonkeyTowerTest {

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
        //t5.putEvolutions(); // 3
        t5.removeEvolution();
        assertEquals(cadenceBefore, t5.getCadence());
    }

}
