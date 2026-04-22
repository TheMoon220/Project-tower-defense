package bloons.action;

import bloons.Position;
import bloons.board.Board;
import bloons.board.ClassicalBoard;
import bloons.tower.Tower;

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

        // check if the position is in the path (for ClassicalBoard)
        if(board instanceof ClassicalBoard){
            if(((ClassicalBoard) board).InPath(position)){
                System.out.println("Position " + position + " in path. Choose another position");
                return false;
            }
        }
        
        // check if the player has enough credit
        if (Board.PLAYER.getCredit() < tower.getCost()) {
            System.out.println("Not enough credits! Need " + tower.getCost() + 
                              ", for buying " + tower.getClass().getSimpleName() + ", have " + Board.PLAYER.getCredit());
            return false;
        }
        
        // Buy and place the tower
        Board.PLAYER.removeCredit((int) tower.getCost());
        board.addTower(tower);
        System.out.println("Bought " + tower + " for " + (int) tower.getCost() + 
                         " credits. Remaining: " + Board.PLAYER.getCredit());
        return true;
    }

     /**
     * Returns a textual description of the action
     * @return description
     */
    @Override
    public String getDescription() {
        return "Buy " + tower.getClass().getSimpleName() + " at " + position + 
               " (cost: " + (int) tower.getCost() + ")";
    }
    
     /**
     * Returns the cost of the action (if applicable)
     * @return the cost, or 0 if the action has no cost
     */
    @Override
    public int getCost() {
        return (int) tower.getCost();
    }

}
