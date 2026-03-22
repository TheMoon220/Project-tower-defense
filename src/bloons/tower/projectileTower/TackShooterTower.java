package bloons.tower.projectileTower;

import bloons.Position;
import bloons.utils.Effect;
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
    public void putEvolutions(){
        switch (this.evolutionIndex) {
            case 1:
                double newRange = this.getCadence() * 1.20;
                this.setRange(newRange);
                System.out.println("TackShooterTower : Range evolutes to 20%");
                break;
            case 2:
                double newCadance = this.getCadence() * 1.25;
                this.setCadence(newCadance);
                System.out.println("TackShooterTower : Cadance evolutes to 25%");
                break;
            default:
                System.out.println("TackShooterTower : no possible evolution");
                return;
        }
        this.evolutionIndex++;
    }
    
}
