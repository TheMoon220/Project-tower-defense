package bloons.tower.projectileTower;

import bloons.Position;
import bloons.utils.Effect;
import bloons.utils.Evolution;
import bloons.utils.Projectile;

/** the object TackShooterTower that send a projectile */
public class TackShooterTower extends ProjectileTower{

    /** constructor of a tower with projectile
     * @param cost the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     * @param position the position of the tower
     */
    public TackShooterTower(double cost, double range, Effect effect, double cadence, Position position, Projectile projectile) {
        super(cost, range, effect, cadence, position, projectile);
    }

    /**
     * put evolutions for tower
     */
    @Override
    public void applyEvolution(Evolution evo){
        switch (evo) {
            case RANGE:
                double newRange = this.getRange() * 1.20;
                this.setRange(newRange);
                System.out.println("TackShooterTower : Range evolutes to 20%");
                break;
            case CADANCE:
                double newCadance = this.getCadence() * 1.25;
                this.setCadence(newCadance);
                System.out.println("TackShooterTower : Cadance evolutes to 25%");
                break;
            default:
                System.out.println("TackShooterTower : no possible evolution");
                return;
        }
    }

     /**
     * remove evolutions for tower
     */
    @Override
    public void removeEvolution(){
        if (this.evolutionIndex == 1) {
            System.out.println("TackShooterTower : no change to remove");
            return;
        }
        this.evolutionIndex--;
        switch (this.evolutionIndex) {
            case 1:
                this.range /= 1.20;
                System.out.println("TackShooterTower : Range decreases to 20%");
                break;
            case 2:
                this.cadence /= 1.25;
                System.out.println("TackShooterTower : Cadance decreases to 25%");
                break;
        }
    }
    
}
