package bloons.tower.projectileTower;

import bloons.tower.Tower;
import bloons.utils.Effect;

public class ProjectileTower extends Tower{

     /** Slow down tower building
     * @param coast the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     */
    public ProjectileTower(double cost, double range, Effect effect, double cadence) {
        super(cost, range, effect, cadence);
    }
    
    
}
