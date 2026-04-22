package bloons.tower.projectileTower;
import bloons.Position;
import bloons.balloon.*;
import bloons.tower.Tower;
import bloons.utils.*;


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
        this.possibleEvolutions.put(Evolution.CADANCE, 200);
        this.possibleEvolutions.put(Evolution.POWER, 300);
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
    public void applyEvolution(Evolution evo){
        switch (evo) {
            case CADANCE:
                double oldCadance = this.getCadence();
                double newCadance = oldCadance * 1.25;
                this.setCadence(newCadance);
                System.out.println("SniperMonkeyTower : Cadance evolute to 25%");
                break;
            case POWER:
                int oldPuissance = this.getProjectil().getNiveauDegat();
                this.projectile.setNiveauDegat(oldPuissance + 2);
                System.out.println("SniperMonkeyTower : Power evolute to 2");
                break;
            default:
                System.out.println("SniperMonkeyTower : no possible evolution");
                return;
        }
    }

     /**
     * remove evolutions for tower
     */
    @Override
    public void removeEvolutionEffect(Evolution evo){
        switch (evo) {
            case CADANCE:
                this.cadence /= 1.25;
                System.out.println("SniperMonkeyTower : Cadance decreases to 25%");
                break;
            case POWER:
                this.projectile.setNiveauDegat(this.projectile.getNiveauDegat() - 2);
                System.out.println("SniperMonkeyTower : Power decreases to 2");
                break;
            default:
                return;
        }
    }
    
}