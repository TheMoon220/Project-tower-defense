package bloons.tower.projectileTower;

import bloons.Position;
import bloons.utils.Effect;
import bloons.utils.Projectile;

/** the object SuperMonkeyTower that send a projectile */
public class SuperMonkeyTower extends ProjectileTower{

    /** constructor of a tower with projectile
     * @param cost the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     * @param position the position of the tower
     */
    public SuperMonkeyTower(double cost, double range, Effect effect, double cadence, Position position, Projectile projectile) {
        super(cost, range, effect, cadence, position, projectile);
    } 

    /**
     * put evolutions for tower
     */
    public void putEvolutions(){
        double oldRange = this.getRange();
        double newRange = oldRange * 1.5;
        this.setRange(newRange);

        int oldPuissance = this.getProjectil().getNiveauDegat();
        this.projectile.setNiveauDegat(oldPuissance + 2);
    }
}
