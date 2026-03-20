package bloons.tower.projectileTower;

import bloons.Position;
import bloons.balloon.*;
import bloons.utils.Effect;
import bloons.utils.Projectile;

/** the object SniperMonkeyTower that send a projectile */
public class SniperMonkeyTower extends ProjectileTower{

    /** constructor of a tower with projectile
     * @param cost the coast of tower
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     * @param position the position of the tower
     */
    public SniperMonkeyTower(double cost, Effect effect, double cadence, Position position, Projectile projectile) {
        super(cost, Double.MAX_VALUE, effect, cadence, position, projectile);
    }

    /**
     * overload the method so that the range is always infinite
     * @param b the balloon
     * @return true
     */
    @Override
    public boolean Inrange(Balloon b){
        return true;
    }

    /**
     * put evolutions for tower
     */
    public void putEvolutions(){
        double oldCadance = this.getCadence();
        double newCadance = oldCadance * 1.25;
        this.setCadence(newCadance);

        int oldPuissance = this.getProjectil().getNiveauDegat();
        this.projectile.setNiveauDegat(oldPuissance + 2);
    }
}