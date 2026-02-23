package bloons.tower;

import bloons.Position;
import bloons.balloon.*;
import bloons.utils.*;

/** the tower that freezes balloons */
public class IceTower extends Tower{
    /** 
     * the constructor of the class Tower
     * @param cost the tower's price
     * @param range the tower's scope
     * @param effect the tower's impact
     * @param cadence the tower's cadence
     * @param timeLastAttack store last shot
     */
    public IceTower(double cost ,double range ,Effect effect ,double cadence,Position position){
        super(cost,range,effect,cadence,position);
    }

    /**
     * freeze a balloon
     * @param b the balloon to freeze
     */
    public void freeze(Balloon b){
       b.setSpeed(0);
    }

    /**  
     * attack all the balloons within the tower's range and freeze them
     * @param balloon the ice balloon 
     */ 
    @Override   
    public void attackBallon(Balloon balloon, long currTime){ 
       if(Inrange(balloon) && canAttack(currTime)){ 
          freeze(balloon); 
          updateLastAttackTime(currTime);
       }
    }
}