package bloons.action;

import bloons.tower.Tower;
import bloons.Position;

/** Action of purchasing and placing a tower */
public class BuyTowerAction implements Action{
    /** the tower */
    private final Tower tower;
    /** a position on the board */
    private final Position position;

    /**
     * Constructor
     * @param tower the tower to buy (already configured with its cost)
     * @param position the position where to place the tower
     */
    public BuyTowerAction(Tower tower, Position position) {
        this.tower = tower;
        this.position = position;
    }

}
