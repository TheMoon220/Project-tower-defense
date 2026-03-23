package bloons.tower.projectileTower;

import bloons.Position;
import bloons.balloon.*;
import bloons.utils.Effect;
import bloons.utils.Projectile;

/** the object DartMonkeyTower */
public class DartMonkeyTower extends ProjectileTower {

     /** constructor of DartMonkeyTower
     * @param cost the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     * @param position the position of the tower
     */
    public DartMonkeyTower(double cost ,double range ,Effect effect ,double cadence,Position position,Projectile projectile){
        super(cost, range, effect, cadence,position, projectile);
    }

    /** first the min of all balloonsiRrange is calulated and this one is the balloons to attack
     * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
     * @param balloon the ballon that can be attacked by the tower
     * @throws InterruptedException when the currentime is not valide
    */
   @Override
    public void attackBallon (Balloon balloon,long time) throws InterruptedException{
        super.attackBallon(balloon, time);
    }

    /**
     * put evolutions for tower
     */
    @Override
    public void putEvolutions(){
        switch (this.evolutionIndex) {
            case 1:
                double newRange = this.getRange() * 0.75;
                this.setRange(newRange);
                System.out.println("DartMonkeyTower : Range evolute to 25%");
                break;
            case 2:
                this.setCadence(this.getCadence() * 0.75);
                System.out.println("DartMonkeyTower : Cadance evolute to 25%");
                break;
            case 3:
                int oldPuissance = this.getProjectil().getNiveauDegat();
                this.projectile.setNiveauDegat(oldPuissance + 1);
                System.out.println("DartMonkeyTower : Puissance evolute to 1");
                break;

            default:
                System.out.println("DartMonkeyTower : no possible evolution");
                return;
        }
        this.evolutionIndex++;
    }

    /**
     * remove evolutions for tower
     */
    @Override
    public void removeEvolution() {
        if (this.evolutionIndex == 1) {
            System.out.println("DartMonkeyTower : no change to remove");
            return;
        }
        this.evolutionIndex--;
        switch (this.evolutionIndex) {
            case 1:
                this.range /= 1.25;
                 System.out.println("DartMonkeyTower : Range decreases to 25%");
                break;
            case 2:
                this.cadence /= 1.25;
                 System.out.println("DartMonkeyTower : Cadence decreases to 25%");
                break;
            case 3:
                this.projectile.setNiveauDegat(this.projectile.getNiveauDegat() - 1);
                System.out.println("DartMonkeyTower : Puissance decreases to 1");
                break;
        }
    }

}
