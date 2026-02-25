package bloons.tower;

import bloons.Position;
import bloons.balloon.Balloon;
import bloons.utils.Effect;

/** the object SlowDownTower that send a projectile */
public class SlowDownTower extends Tower {

    /** Slow down tower building
     * @param cost the cost of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     * @param position the position of the tower
     */
    public SlowDownTower(double cost ,double range ,Effect effect ,double cadence,Position position){
        super(cost, range, effect, cadence,position);
    }

    /**
     * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
     * @param balloon the ballon that can be attacckek by the tower
     */
    @Override
    public void attackBallon (Balloon balloon, long currTime){
        if(Inrange(balloon) && canAttack(currTime)){
          double newSpeed = balloon.getSpeed() * 0.5; 
          balloon.setSpeed(newSpeed);
          updateLastAttackTime(currTime);
        }
    }
}