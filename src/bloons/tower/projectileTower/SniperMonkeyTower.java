package bloons.tower.projectileTower;

import bloons.Position;
import bloons.balloon.*;
import bloons.utils.Effect;
import bloons.utils.Projectile;

public class SniperMonkeyTower extends ProjectileTower{

    /** constructor of a tower with projectile
     * @param cost the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     */
    public SniperMonkeyTower(double cost, Effect effect, double cadence, Position position, Projectile projectile) {
        super(cost, Double.MAX_VALUE, effect, cadence, position, projectile);
    }

    /**
     * overload the method so that the range is always infinite
     * @param b
     */
    @Override
    public boolean Inrange(Balloon b){
        return true;
    }
}
