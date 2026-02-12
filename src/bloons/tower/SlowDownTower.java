package bloons.tower;

import bloons.Balloon;
import bloons.utils.Effect;
import bloons.utils.Projectile;

public class SlowDownTower extends Tower {
    private Projectile projectile ;
    public SlowDownTower(double coast ,double range ,Effect effect ,double cadence,Projectile projectile){
        super(coast, range, effect, cadence);
        this.projectile=projectile;

    }

    public void attackBallon (Balloon balloon){

    }

}
