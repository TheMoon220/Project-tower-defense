package bloons.tower;

import bloons.Position;
import bloons.balloon.Balloon;
import bloons.utils.Effect;

public abstract class Tower {

    protected double cost; // the tower's cost 
    protected double range; // the range of the 
    private  Effect effect ; // the effect when a balloon is hit
    private Position position ; // the position of the tower
    private double cadence ; // the cadence of the tower
     
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
    }

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
    public double getRange(){
      return this.range ;
    }

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
     * allow to get the tower effect
     * @return the tower effect
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
    public abstract void attackBallon(Balloon ballon);
}
