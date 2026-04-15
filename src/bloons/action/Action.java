package bloons.action;

import bloons.board.Board;

/**
 * Interface representing an action that the player can perform
 */
public interface Action {
    
    /**
     * Perform the action on the board
     * @param board the game board
     * @return true if the action was successful, false otherwise
     */
    boolean execute(Board board);
    
    /**
     * Returns a textual description of the action
     * @return description
     */
    String getDescription();
    
    /**
     * Returns the cost of the action (if applicable)
     * @return the cost, or 0 if the action has no cost
     */
    default int getCost() {
        return 0;
    }
}