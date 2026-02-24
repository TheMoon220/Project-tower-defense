package bloons.tower.projectileTower;

import bloons.Position;
import bloons.balloon.*;
import bloons.utils.*;

import java.util.*;

/** the object Bomb tower, the tower that sends bombs */
public class BombTower extends ProjectileTower {
    
     /** 
     * the constructor of the class Tower
     * @param cost the tower's price
     * @param range the tower's scope
     * @param effect the tower's impact
     * @param cadence the tower's cadence
     */
    public BombTower(double cost ,double range ,Effect effect ,double cadence,Position position, Projectile projectile){
       super(cost, range, effect, cadence,position, projectile);
    }

    /**  
     * attack the most advanced balloon in range and a random balloon nearby
     * @param balloon the balloon 
     * @param currTime the current TIme
    */ 
    @Override
    public void attackBallon(Balloon balloon, long currTime) throws InterruptedException{
        if(canAttack(currTime) && Inrange(balloon)){
            super.attackBallon(balloon,currTime);

            this.getAllBalloonsInRange();
            this.balloonsInRange.remove(balloon);
            if(!this.balloonsInRange.isEmpty()){
               int size =this.balloonsInRange.size();
               Balloon bal = this.balloonsInRange.get(new Random().nextInt(size));
               int newHealth = bal.getHealth() - this.projectile.getNiveauDegat();
               bal.setHealth(newHealth);

               if (newHealth <= 0) 
                  balloons.remove(bal);
            }
        }
    }
}
