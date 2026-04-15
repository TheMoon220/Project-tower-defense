package bloons.tower;

import bloons.Position;
import bloons.balloon.Balloon;
import bloons.utils.Effect;
import bloons.utils.Evolution;

/** the object SlowDownTower that send a projectile */
public class SlowDownTower extends Tower {
    // an variable for the speed;
    private double reelSpeed = -1;

    /** Slow down tower building
     * @param cost the cost of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param position the position of the tower
     */
    public SlowDownTower(double cost ,double range ,Effect effect ,double cadence,Position position){
        super(cost, range, effect, cadence,position);
    }

    /**
     * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
     * @param balloon the ballon that can be attacckek by the tower
     */
    @Override
    public void attackBallon (Balloon balloon, long currTime){
        if(Inrange(balloon) && canAttack(currTime)){
          if(this.reelSpeed == -1){
            this.reelSpeed = balloon.getSpeed();
          }
          balloon.setSpeed(this.reelSpeed * 0.5);
          updateLastAttackTime(currTime);
        } else if(!Inrange(balloon) && this.reelSpeed != -1){
            balloon.setSpeed(reelSpeed);
            this.reelSpeed = -1;
        }
    }

    /**
     * put any evolutions for tower
     */
    @Override
    public void putEvolutions() {
        System.out.println("SlowDownTower : can't be evolute");
    }

     /**
     * remove any evolutions for tower
     */
    @Override
    public void removeEvolution() {
        System.out.println("SlowDownTower : no change to remove");
    }

    @Override
    public void applyEvolution(Evolution evo){}

    @Override
    public void removeEvolutionEffect(Evolution evo){}

    /**
     * @return true if tower can be evolute
     */
    public boolean canBeEvolute(){
      return false;
    }
}