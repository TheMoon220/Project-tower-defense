package bloons.action;

import bloons.tower.Tower;
import bloons.Position;
import bloons.board.Board;

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

    /**
     * Perform the action on the board
     * @param board the game board
     * @return true if the action was successful, false otherwise
    */
    @Override
    public boolean execute(Board board) {
        // check if the position is valide
        if (position.getX() < 0 || position.getX() >= board.getWidth() ||
            position.getY() < 0 || position.getY() >= board.getHeight()) {
            System.out.println("Invalid position: " + position);
            return false;
        }
        
        // check that if the position is not occupied
        if (board.isPositionOccupiedByTower(position)) {
            System.out.println("Position " + position + " is already occupied by a tower!");
            return false;
        }
        
        // check if the player has enough credit
        if (Board.PLAYER.getCredit() < tower.getCost()) {
            System.out.println("Not enough credits! Need " + tower.getCost() + 
                             ", have " + Board.PLAYER.getCredit());
            return false;
        }
        
        // Buy and place the tower
        Board.PLAYER.removeCredit((int) tower.getCost());
        board.addTower(tower);
        System.out.println("Bought " + tower + " for " + (int) tower.getCost() + 
                         " credits. Remaining: " + Board.PLAYER.getCredit());
        return true;
    }

}
