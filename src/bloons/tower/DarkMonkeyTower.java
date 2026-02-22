package bloons.tower;

import bloons.Balloon;
import bloons.utils.Effect;
import bloons.utils.Projectile;

public class DarkMonkeyTower extends Tower {
    private Projectile projectile ;
    public DarkMonkeyTower(double coast ,double range ,Effect effect ,double cadence,Projectile projectile){
        super(coast, range, effect, cadence);
        this.projectile=projectile;

    }
    /** first the min of all balloonsiRrange is calulated and this one is the balloons to attack
 * attack the ballon when this one is one this range(portee) and probably change the the ballon ballon caracteristic 
 * @param ballon the ballon that can be attacckek by the tower
     * @throws InterruptedException 
 */
    public void attackBallon (Balloon balloon) throws InterruptedException{
        double min=0;
        for(Balloon b:balloonsInRange.keySet()){
             double min1=balloonsInRange.get(b);
             if(balloonsInRange.get(b)<min1){
                min1=balloonsInRange.get(b);
                Balloon balloonToAttack=b ;
             }
        }
        
        if(balloon.getLevel().getResistance()<this.projectile.getNiveauDegat()){
            balloons.remove(balloon);

        }
        balloon.getLevel().setResistance();
         Thread.sleep((long) cadence);
     
    }
/**
 * allow to change the current projectile by a new projectile
 * @param newProjectile the new projectile that replacing projectile
 */
    public void setProjectile(Projectile newProjectile){
        this.projectile =newProjectile ;

    }
    

}
