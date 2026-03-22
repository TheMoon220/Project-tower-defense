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
    @Override
    public void putEvolutions(){
        switch (this.evolutionIndex) {
            case 1:
                double newRange = this.getCadence() * 1.5;
                this.setRange(newRange);
                System.out.println("SuperMonkeyTower : Range evolutes to 50%");
                break;
            case 2:
                double newCadance = this.getCadence() * 3;
                this.setCadence(newCadance);
                System.out.println("SuperMonkeyTower : Cadance evolutes to 200%");
                break;
            case 3:
                int oldPuissance = this.getProjectil().getNiveauDegat();
                this.projectile.setNiveauDegat(oldPuissance + 2);
                System.out.println("SuperMonkeyTower : Puissance evolutes to 2");
                break;

            default:
                System.out.println("SuperMonkeyTower : no possible evolution");
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
            System.out.println("SuperMonkeyTower : no change to remove");
            return;
        }
        this.evolutionIndex--;
        switch (this.evolutionIndex) {
            case 1:
                this.range /= 1.5;
                System.out.println("SuperMonkeyTower : Range decreases to 50%");
                break;
            case 2:
                this.range/= 3;
                System.out.println("SuperMonkeyTower : Cadance decreases to 200%");
                break;
            case 3:
                this.projectile.setNiveauDegat(this.projectile.getNiveauDegat() - 2);
                System.out.println("SuperMonkeyTower : Puissance decreases to 2");
                break;
        }
    }

    
}
