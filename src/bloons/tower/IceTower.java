package bloons.tower;

import bloons.balloon.*;
import bloons.utils.*;

/** the tower that freezes balloons */
public class IceTower extends Tower{
    private long timeLastAttack;

    /** 
     * the constructor of the class Tower
     * @param coast the tower's price
     * @param range the tower's scope
     * @param effect the tower's impact
     * @param cadence the tower's cadence
     * @param timeLastAttack store last shot
     */
    public IceTower(double coast ,double range ,Effect effect ,double cadence){
        super(coast,range,effect,cadence);
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
     * check if the balloon is in the range of the tower
     * @param b the balloon
     */
    private boolean isInRange(Balloon b){
        double x = b.getPosition().getX() - this.position.getX();
        double y = b.getPosition().getY() - this.position.getY();
        return Math.sqrt(x * x + y * y) <= this.range * this.range;
    }

    /**  
     * attack all the balloons within the tower's range and freeze them
     * @param balloon the ice balloon 
     */    
    public void attackBallon(Balloon balloon){
       // TO DO
    }
}
