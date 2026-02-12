package bloons.tower;

import bloons.Balloon;
import bloons.Position;
import bloons.utils.Effect;
import bloons.utils.Projectile;

public abstract class Tower {
    protected double coast;
    protected double range;
    private  Effect effect ;
    private Position position ;
    private double cadence ;
     
    public Tower(double coast ,double range ,Effect effect ,double cadence){
        this.coast=coast ;
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
  public  abstract   void setRange();

  
/**
     * to set the cadence of the tower during the evolution
     */
  public   void setCadence() {
    this.cadence=cadence ;
  }
  
/**
     * allow to get the tower effect
     * @return the tower effect
     */

  public double getCoast(){
    return this.coast ;
  }

  public abstract void attackBallon(Balloon ballon);
  
}
