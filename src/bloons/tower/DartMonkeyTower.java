package bloons.tower;

import bloons.balloon.Balloon;
import bloons.utils.Effect;

public class DartMonkeyTower extends Tower{

    public DartMonkeyTower(double cost, double range, Effect effect, double cadence) {
        super(cost, range, effect, cadence);
    
    }

    @Override
    public void attackBallon(Balloon ballon) {
        
    }

}
