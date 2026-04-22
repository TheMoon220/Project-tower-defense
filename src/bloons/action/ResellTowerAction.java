package bloons.action;

import bloons.board.Board;
import bloons.tower.Tower;

public  class  ResellTowerAction implements Action {

      private final Tower tower;
      /**
     * Constructor
     * @param tower the tower to buy (already configured with its cost)
     * @param position the position where to place the tower
     */
    public ResellTowerAction(Tower tower) {
        this.tower = tower;
    }

    /**
     * Perform the action on the board
     * @param board the game board
     * @return true if the action was successful, false otherwise
     */
    boolean execute(Board board){
        if (this.tower== null){
            return false ;
        }
        tower.resellTower(board);
        return true;

    }
    
    /**
     * Returns a textual description of the action
     * @return description
     */
    String getDescription(){
        
    }
    
    /**
     * Returns the cost of the action (if applicable)
     * @return the cost, or 0 if the action has no cost
     */
    public int getCost(){

    }
    
}
