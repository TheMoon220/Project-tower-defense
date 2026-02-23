package bloons.tower;

import bloons.balloon.*;
import bloons.utils.*;

/** the tower that freezes balloons */
public class IceTower extends Tower{
    private long timeLastAttack;

    /** 
     * the constructor of the class Tower
     * @param cost the tower's price
     * @param range the tower's scope
     * @param effect the tower's impact
     * @param cadence the tower's cadence
     * @param timeLastAttack store last shot
     */
    public IceTower(double cost ,double range ,Effect effect ,double cadence){
        super(cost,range,effect,cadence);
        this.timeLastAttack = 0;
    }

    /**
     * get the last shot
     * @return timeLastAttack
     */
    public long getTimeLastAttack(){
        return this.timeLastAttack;
    }

    /** 
     * check if the tower can attack
     * @param currTime the current time
     * @return true when can attack otherwise false
     */
    private boolean canAttack(long currTime){
        return currTime - this.timeLastAttack >= this.cadence;
    }

    /**
     * update the last time attack
     * @param currTime
     */
    public void updateLastAttackTime(long currTime){
       this.timeLastAttack = currTime;
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
    public void attackBallon(Balloon balloon){ 
       long currTime = System.currentTimeMillis();
       if(Inrange(balloon) && canAttack(currTime)){ 
          freeze(balloon); 
          updateLastAttackTime(currTime);
       }
    }
}