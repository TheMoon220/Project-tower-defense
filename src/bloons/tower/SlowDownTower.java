package bloons.tower;

import bloons.balloon.Balloon;
import bloons.utils.Effect;
import bloons.utils.Projectile;

public class SlowDownTower extends Tower {
    private Projectile projectile ;
    public SlowDownTower(double coast ,double range ,Effect effect ,double cadence,Projectile projectile){
        super(coast, range, effect, cadence);
        this.projectile=projectile;

    }
    /**
 * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
 * @param ballon the ballon that can be attacckek by the tower
 */
    public void attackBallon (Balloon balloon){

    }
/**
 * allow to change the current projectile by a new projectile
 * @param newProjectile the new projectile that replacing projectile
 */
    public void setProjectile(Projectile newProjectile){
        this.projectile =newProjectile ;

    }

}
