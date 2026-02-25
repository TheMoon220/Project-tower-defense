package bloons.tower;

import bloons.Position;
import bloons.balloon.*;
import bloons.utils.*;

/** the tower that freezes balloons */
public class IceTower extends Tower{
    private double reelSpeed = -1; // an variable for the speed
    /** 
     * the constructor of the class Tower
     * @param cost the tower's price
     * @param range the tower's scope
     * @param effect the tower's impact
     * @param cadence the tower's cadence
     * @param position the position of the tower
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
     * @param currTime the current time
     */ 
    @Override   
    public void attackBallon(Balloon balloon, long currTime){ 
       if(Inrange(balloon) && canAttack(currTime)){ 
         if(this.reelSpeed == -1)
            this.reelSpeed = balloon.getSpeed();
         freeze(balloon); 
         updateLastAttackTime(currTime);
       }else if(!Inrange(balloon) && reelSpeed != - 1){
         balloon.setSpeed(this.reelSpeed);
         this.reelSpeed = -1;
       }
    }
}