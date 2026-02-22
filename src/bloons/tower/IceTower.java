package bloons.tower;

import bloons.balloon.*;
import bloons.utils.*;

/** the tower that freezes balloons */
public class IceTower extends Tower{

    /** 
     * the constructor of the class Tower
     * @param coast the tower's price
     * @param range the tower's scope
     * @param effect the tower's impact
     * @param cadence the tower's cadence
     */
    public IceTower(double coast ,double range ,Effect effect ,double cadence){
        super(coast,range,effect,cadence);
    }

    /**  
     * attack all the balloons within the tower's range and freeze them
     * @param balloon the ice balloon 
     */    
    public void attackBallon(Balloon balloon){
       // TO DO
    }
}
