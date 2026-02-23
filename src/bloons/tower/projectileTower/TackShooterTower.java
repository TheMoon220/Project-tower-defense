package bloons.tower.projectileTower;

import bloons.Position;
import bloons.utils.Effect;
import bloons.utils.Projectile;

public class TackShooterTower extends ProjectileTower{

    public TackShooterTower(double cost, double range, Effect effect, double cadence, Position position,
            Projectile projectile) {
        super(cost, range, effect, cadence, position, projectile);
    }
    
}
