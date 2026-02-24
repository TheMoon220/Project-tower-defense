package bloons.tower.projectileTower;

import bloons.Position;
import bloons.balloon.Balloon;
import bloons.tower.Tower;
import bloons.utils.*;


public class ProjectileTower extends Tower{

    protected Projectile projectile;

     /** constructor of a tower with projectile
     * @param cost the coast of tower
     * @param range the range of tower 
     * @param effect the effect of tower
     * @param cadence the cadence of tower
     * @param projectile the projectile of tower
     */
    public ProjectileTower(double cost, double range, Effect effect, double cadence,Position position, Projectile projectile) {
        super(cost, range, effect, cadence,position);
        this.projectile=projectile;
    }
    
    /** first the min of all balloonsiRrange is calulated and this one is the balloons to attack
     * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
     * @param ballon the ballon that can be attacckek by the tower
     * @throws InterruptedException 
    */
    @Override
    public void attackBallon (Balloon balloon,long time) throws InterruptedException{
       if(Inrange(balloon) && canAttack(time)){
          int newHealth = balloon.getHealth() - this.projectile.getNiveauDegat();
          balloon.setHealth(newHealth);
          if(newHealth <= 0){
            this.balloons.remove(balloon);
          }

          updateLastAttackTime(time);
       }
    }

    /** return tower's projectile
     * @return tower's projectile
     */
    public Projectile getProjectil(){
        return this.projectile;
    }
<<<<<<< HEAD

=======
>>>>>>> ef74c77 (Mis a jou)
    /**
     * allow to change the current projectile by a new projectile
     * @param newProjectile the new projectile that replacing projectile
     */
    public void setProjectile(Projectile newProjectile){
        this.projectile =newProjectile ;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> ef74c77 (Mis a jou)
