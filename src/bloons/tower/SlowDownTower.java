package bloons.tower;

import bloons.Position;
import bloons.balloon.Balloon;
import bloons.utils.Effect;

public class SlowDownTower extends Tower {

    /** Slow down tower building
     * @param cost the cost of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     */
    public SlowDownTower(double cost ,double range ,Effect effect ,double cadence,Position position){
        super(cost, range, effect, cadence,position);
    }

    /**
     * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
     * @param ballon the ballon that can be attacckek by the tower
     */
    public void attackBallon (Balloon balloon){
        balloon.setHealth();
    }

}
