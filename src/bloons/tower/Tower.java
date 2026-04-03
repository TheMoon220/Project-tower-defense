package bloons.tower;

import bloons.Position;
import bloons.balloon.Balloon;
import bloons.utils.Effect;
import bloons.utils.Evolution;

import java.util.*;

/** the object Tower an abstract class for the towers */
public abstract class Tower {
    /** the tower's cost */
    protected double cost;
    
    /** the range of the */ 
    protected double range; 
    /** the effect when a balloon is hit */
    protected Effect effect ; 
    /** the position of the tower */
    protected Position position ; 
    /** the cadence of the tower */
    protected double cadence ; 
    /** the currentime */
    protected long timeLastAttack ; 

    /** all balloons on path */
    protected  List<Balloon> balloons ; 
    /** all ballon in the tower range */
    protected  List<Balloon > balloonsInRange ;
    /** Range is the the range that choosen on an specifique echelle (every cell is corresponding to 60) */
    public double RANGE=60; 

    protected List<Evolution> possibleEvolutions;
    protected Deque<Evolution> appliedEvolutions; 

     
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
        this.possibleEvolutions = new ArrayList<>();
        this.appliedEvolutions = new ArrayDeque<>();
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
     * @param cadence the cadence of the tower
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
    * to set the range of the tower during the evolution
    * @param newRange the new range
    */
    public void setRange(double newRange){
      this.range = newRange ;
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
     * @param time waiting for attack
     * @exception InterruptedException when currentime is not correct
     */
    public abstract void attackBallon(Balloon ballon,long time) throws InterruptedException;


    /**
     * chech if the distance between the ballon  and the tower position is equal to the distance of the range
     * @param B the balloon
     * @return true if is in range otherwise false
     */
    public boolean Inrange(Balloon B){
      return calculDistance(B)<=this.range/RANGE;
    }

    /**
     * an methode for calculate dhe distance between the balloon and the tower
     * @param B the balloon
     * @return the distance
     */
    protected double calculDistance(Balloon B){
      double dx = Math.abs( B.getPosition().getX()-position.getX() );
      double dy = Math.abs( B.getPosition().getY()-position.getY() );
      return Math.sqrt((dx*dx +dy*dy));
    }

    /**
     * add the list of balloons
     * @param theballoons to add
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
     * @param currTime the current time
     */
    protected void updateLastAttackTime(long currTime){
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

    /**
     * get the balloons around the range of the tower
     * @return balloons in range
     */
    public List<Balloon> getBalloonsInRange() {
      return this.balloonsInRange;
    }

    /**
     * a description for each tower with his position on the board
     * @return a string 
     */
    @Override
    public String toString() {
      return this.getClass().getSimpleName() + " at " + this.position;
    }

    /** return the closest balloon to exit
     * @return the closest balloon to exit
     */
    public Balloon getBalloonClosestToExit(){
        Balloon ballon = null;
        double maxDistance = -1;
        for (Balloon b : this.balloonsInRange) {
            if (b.isDestroyed()){
                continue;
            }
            double distance = b.getCurrentCellIndex() + b.getProgress();
            if (distance > maxDistance) {
                maxDistance = distance;
                ballon = b;
            }
        }
        return ballon;
    }

    /**
     * put evolution for tower
     */
    public void putEvolutions(){
      if (this.appliedEvolutions.size() >= this.possibleEvolutions.size()) {
        System.out.println(this.getClass().getSimpleName()  + " : No possible evolution");
        return;
      }
      Evolution next = this.possibleEvolutions.get(this.appliedEvolutions.size());
      this.appliedEvolutions.push(next);
      this.applyEvolution(next);
    }

    public abstract void applyEvolution(Evolution evo);
    public abstract void removeEvolutionEffect(Evolution evo);

    /**
     * remove evolution for tower
     */
    public void removeEvolution(){
      if (this.appliedEvolutions.isEmpty()) {
        System.out.println(this.getClass().getSimpleName() + " : No change to remove");
        return;
      }
      Evolution last = this.appliedEvolutions.pop();
      this.removeEvolutionEffect(last);
    }
}