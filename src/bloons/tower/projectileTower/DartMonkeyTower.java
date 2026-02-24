package bloons.tower.projectileTower;

import bloons.Position;
import bloons.balloon.*;
import bloons.utils.Effect;
import bloons.utils.Projectile;

public class DartMonkeyTower extends ProjectileTower {

     /** constructor of DartMonkeyTower
     * @param cost the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     */
    public DartMonkeyTower(double coast ,double range ,Effect effect ,double cadence,Position position,Projectile projectile){
        super(coast, range, effect, cadence,position, projectile);
    }

<<<<<<< HEAD
    /** first the min of all balloonsiRrange is calulated and this one is the balloons to attack
     * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
     * @param ballon the ballon that can be attacckek by the tower
     * @throws InterruptedException 
    */
   @Override
    public void attackBallon (Balloon balloon,long time) throws InterruptedException{
        super.attackBallon(balloon, time);
    }
=======
    

    /**
     * allow to change the current projectile by a new projectile
     * @param newProjectile the new projectile that replacing projectile
     */
    public void setProjectile(Projectile newProjectile){
        this.projectile =newProjectile ;
    }
    

>>>>>>> ef74c77 (Mis a jou)
}
