package bloons.tower;

import bloons.balloon.*;
import bloons.utils.*;

/** the object Bomb tower, the tower that sends bombs */
public class BombTower extends Tower {
    
     /** 
     * the constructor of the class Tower
     * @param cost the tower's price
     * @param range the tower's scope
     * @param effect the tower's impact
     * @param cadence the tower's cadence
     */
    public BombTower(double cost ,double range ,Effect effect ,double cadence){
       super(cost, range, effect, cadence);
    }

     /**  
     * attack all the balloons within the tower's range and freeze them
     * @param balloon the ice balloon 
     */ 
    public void attackBallon(Balloon balloon){
        //TO DO
    }
}
