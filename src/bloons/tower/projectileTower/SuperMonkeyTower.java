package bloons.tower.projectileTower;

import bloons.Position;
import bloons.tower.Tower;
import bloons.utils.Effect;
import bloons.utils.Evolution;
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
        this.possibleEvolutions.put(Evolution.CADANCE, 1000);
        this.possibleEvolutions.put(Evolution.POWER, 600);
        this.possibleEvolutions.put(Evolution.RANGE, 400);
    } 

    /**
     * put evolutions for tower
     */
    @Override
    public void applyEvolution(Evolution evo){
        switch (evo) {
            case RANGE:
                double newRange = this.getRange() * 1.5;
                this.setRange(newRange);
                System.out.println("SuperMonkeyTower : Range evolutes to 50%");
                break;
            case CADANCE:
                double newCadance = this.getCadence() * 3;
                this.setCadence(newCadance);
                System.out.println("SuperMonkeyTower : Cadance evolutes to 200%");
                break;
            case POWER:
                int oldPuissance = this.getProjectil().getNiveauDegat();
                this.projectile.setNiveauDegat(oldPuissance + 2);
                System.out.println("SuperMonkeyTower : Power evolutes to 2");
                break;

            default:
                System.out.println("SuperMonkeyTower : no possible evolution");
                return;
        }
        
    }

    /**
     * remove evolutions for tower
     */
    @Override
    public void removeEvolutionEffect(Evolution evo){

        switch (evo) {
            case RANGE:
                this.range /= 1.5;
                System.out.println("SuperMonkeyTower : Range decreases to 50%");
                break;
            case CADANCE:
                this.cadence /= 3;
                System.out.println("SuperMonkeyTower : Cadance decreases to 200%");
                break;
            case POWER:
                this.projectile.setNiveauDegat(this.projectile.getNiveauDegat() - 2);
                System.out.println("SuperMonkeyTower : Power decreases to 2");
                break;
            default:
                return;
        }
    }
    /**
     * resell  the tower
     * @param tower
     */
    @Override
    public void resellTower(Tower tower){

    }
    /**
     * check if the tower has an evolution
     */
     public boolean  hasAnEvolution(Tower tower){
        return true;
    }

    
}
