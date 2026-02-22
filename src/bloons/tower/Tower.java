package bloons.tower;


import bloons.Position;
import bloons.balloon.Balloon;
import bloons.utils.Effect;
import java.util.*;


import bloons.utils.*;
/**
 * 
 */
public abstract class Tower {


    protected double cost; // the tower's cost 
    protected double range; // the range of the 
    protected Effect effect ; // the effect when a balloon is hit
    protected Position position ; // the position of the tower
    protected double cadence ; // the cadence of the tower
    protected double coast;
    
    
    
    protected  List<Balloon> balloons ;
    protected  Map<Balloon,Double > balloonsInRange ;
    public  double RANGE =60 *range ;
     
    /** tower building
     * @param coast the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     */
    public Tower(double cost ,double range ,Effect effect ,double cadence){
        this.cost=cost ;
        this.range=range ;
        this.effect =effect ;
        this.cadence=cadence ;
        this.balloonsInRange=new HashMap<>();}

    /**
     * allow to get the tower effect
     * @return the tower effect
     */
    public Effect getEffect(){
      return this.effect ;
    
    }
    /**
     * to set the range of the tower during the evolution
     */
    

    /**
     * get the cadence
     * @return cadence
     */
    public double getCadence(){
      return this.cadence;
    }

    /**
     * to set the cadence of the tower during the evolution
     */
    public void setCadence(double cadence) {
      this.cadence=cadence ;
    }

  /**
     * to set the range of the tower during the evolution
  */
  public     double getRange(){
    return this.range ;
  }

  
/**
* to set the cadence of the tower during the evolution
*/
  public   void setCadence() {
    this.cadence=cadence ;
  }

  
    /**
     * allow to get the tower effect
     * @return the tower effect
<<<<<<< HEAD
     */
    public double getCost(){
      return this.cost ;
    }

    /**
     * get the position of the tower
     * @return the position of the tower
     */
    public Position getPosition(){
      return this.position;
    }

    /**
     * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
     * @param ballon the ballon that can be attacckek by the tower
     */
    

  public double getCoast(){
    return this.coast ;
  }
/**
 * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
 * @param ballon the ballon that can be attacckek by the tower
 */
  public abstract void attackBallon(Balloon ballon) throws InterruptedException;
  /**
   * chech if the distance between the ballon  and the tower position is equal to the distance of the range
   * @param B
   * @return
   */
  public boolean Inrange(Balloon B){

      double dx=B.getPosition().getX()-position.getX();
      double dy=B.getPosition().getY()-position.getY();

     return   Math.sqrt((dx*dx +dy*dy))<=RANGE;
    }

    protected double calculDistance(Balloon B){
      double dx=B.getPosition().getX()-position.getX();
      double dy=B.getPosition().getY()-position.getY();
      return Math.sqrt((dx*dx +dy*dy));
    }
/**
 * add the list of balloons
 * @param theballoons
 */
    public void addBalloons(List<Balloon> theballoons){
      this.balloons=theballoons ;
    }

  /**
   * allow to get all balloons in the tower range
   *  */  
  public void getAllBalloonsInRange(){
        for(Balloon b :balloons){
          double d =  calculDistance(b);
            if (this.Inrange(b)){
                balloonsInRange.put(b, d);
            }
        }

  }

}
    
