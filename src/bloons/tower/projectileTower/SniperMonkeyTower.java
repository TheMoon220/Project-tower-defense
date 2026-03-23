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
    @Override
    public void putEvolutions(){
        switch (this.evolutionIndex) {
            case 1:
                double oldCadance = this.getCadence();
                double newCadance = oldCadance * 1.25;
                this.setCadence(newCadance);
                System.out.println("SniperMonkeyTower : Cadance evolute to 25%");
                break;
            case 2:
                int oldPuissance = this.getProjectil().getNiveauDegat();
                this.projectile.setNiveauDegat(oldPuissance + 2);
                System.out.println("SniperMonkeyTower : Puissance evolute to 2");
                break;
            default:
                System.out.println("SniperMonkeyTower : no possible evolution");
                return;
        }
        this.evolutionIndex++;
    }

     /**
     * remove evolutions for tower
     */
    @Override
    public void removeEvolution(){
        if (this.evolutionIndex == 1) {
            System.out.println("SniperMonkeyTower : no change to remove");
            return;
        }
        this.evolutionIndex--;
        switch (this.evolutionIndex) {
            case 1:
                this.cadence /= 1.25;
                System.out.println("SniperMonkeyTower : Cadance decreases to 25%");
                break;
            case 2:
                this.projectile.setNiveauDegat(this.projectile.getNiveauDegat() - 2);
                System.out.println("SniperMonkeyTower : Puissance decreases to 2");
                break;
        }
    }
}