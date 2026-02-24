package bloons.tower;


import bloons.Position;
import bloons.balloon.Balloon;
import bloons.utils.Effect;
import java.util.*;

public abstract class Tower {
    protected double cost; // the tower's cost 
    protected double range; // the range of the 
    protected Effect effect ; // the effect when a balloon is hit
    protected Position position ; // the position of the tower
    protected double cadence ; // the cadence of the tower
    protected long timeLastAttack ;
    
    protected  List<Balloon> balloons ;// all balloons on path
    protected  List<Balloon > balloonsInRange ;// all ballon in the tower range
    public double RANGE = range /60; //Range is the the range that choosen on an specifique echelle (every cell is corresponding to 60)
     
    /** tower building
     * @param cost the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param position the position of the tower
     */
    public Tower(double cost ,double range ,Effect effect ,double cadence,Position position){
        this.cost=cost ;
        this.range=range ;
        this.effect =effect ;
        this.cadence=cadence ;
        this.balloonsInRange=new ArrayList<>();
        this.position=position;
        this.timeLastAttack = 0;
    }

    /**
     * allow to get the tower effect
     * @return the tower effect
     */
    public Effect getEffect(){
      return this.effect ;
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
    * to set the range of the tower during the evolution
    * @return the range
    */
    public double getRange(){
      return this.range ;
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
     * @param the time waiting for attack
     */
    public abstract void attackBallon(Balloon ballon,long time) throws InterruptedException;


    /**
     * chech if the distance between the ballon  and the tower position is equal to the distance of the range
     * @param B the balloon
     * @return true if is in range otherwise false
     */
    public boolean Inrange(Balloon B){
      return calculDistance(B)<=RANGE;
    }

    /**
     * an methode for calculate dhe distance between the balloon and the tower
     * @return the distance
     */
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
    */  
    public void getAllBalloonsInRange(){
      this.balloonsInRange.clear();
      for(Balloon b :balloons){
        if (this.Inrange(b)){
          this.balloonsInRange.add(b);
        }
      }
    
    }

    /**
     * update the last time attack
     * @param currTime
     */
    public void updateLastAttackTime(long currTime){
      this.timeLastAttack = currTime;
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
    public boolean canAttack(long currTime){
      return currTime - this.timeLastAttack >= this.cadence;
    }
}
    
