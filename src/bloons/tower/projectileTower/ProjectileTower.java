package bloons.tower.projectileTower;

import bloons.balloon.Balloon;
import bloons.tower.Tower;
import bloons.utils.Effect;
import bloons.utils.Projectile;

public class ProjectileTower extends Tower{

    protected Projectile projectile;

     /** Slow down tower building
     * @param coast the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     */
    public ProjectileTower(double cost, double range, Effect effect, double cadence, Projectile projectile) {
        super(cost, range, effect, cadence);
        this.projectile=projectile;
    }

     @Override
     public void attackBallon(Balloon ballon) throws InterruptedException {
      
     }
    
    
}
