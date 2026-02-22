package bloons.tower.projectileTower;

import bloons.balloon.Balloon;
import bloons.tower.Tower;
import bloons.utils.*;


public class ProjectileTower extends Tower{

    protected Projectile projectile;

     /** constructor of a tower with projectile
     * @param cost the coast of tower
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

    /** return tower's prjetile
     * @return tower's prjetile
     */
    public Projectile getProjectil(){
        return this.projectile;
    }
    
    
}
