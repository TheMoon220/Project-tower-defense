package bloons.action;

import bloons.board.Board;
import bloons.tower.Tower;

/**
 * Action d'évolution d'une tour
 */
public class UpgradeTowerAction implements Action {
    /** the tower */
    private final Tower tower;
    
    /**
     * Constructor
     * @param tower the tower to be upgraded
     */
    public UpgradeTowerAction(Tower tower) {
        this.tower = tower;
    }
    
    /**
     * Perform the action on the board
     * @param board the game board
     * @return true if the action was successful, false otherwise
    */
    @Override
    public boolean execute(Board board) {
        // check if the position is valide
        if (!board.getAllTowers().contains(tower)) {
            System.out.println("Tower " + tower + " is not on the board!");
            return false;
        }
        
        // check that if the position is not occupied
        if (tower.getAppliedEvolutions().size() >= tower.getPossibleEvolutions().size()) {
            System.out.println(tower.getClass().getSimpleName() + " cannot evolve further!");
            return false;
        }
        
        // check if the player has enough credit
        var evolutions = new java.util.ArrayList<>(tower.getPossibleEvolutions().keySet());
        var nextEvolution = evolutions.get(tower.getAppliedEvolutions().size());
        int cost = tower.getPossibleEvolutions().get(nextEvolution);
        
        // check the credits
        if (Board.PLAYER.getCredit() < cost) {
            System.out.println("Not enough credits! Need " + cost + 
                             ", have " + Board.PLAYER.getCredit());
            return false;
        }
        
        // evolution applicate
        Board.PLAYER.removeCredit(cost);
        tower.getAppliedEvolutions().push(nextEvolution);
        tower.applyEvolution(nextEvolution);
        
        System.out.println("Upgraded " + tower.getClass().getSimpleName() + " at " + 
                         tower.getPosition() + " with " + nextEvolution + 
                         " (cost: " + cost + "). Remaining: " + Board.PLAYER.getCredit());
        return true;
    }
    
    /**
     * Returns a textual description of the action
     * @return description
     */
    @Override
    public String getDescription() {
        return "Upgrade " + tower.getClass().getSimpleName() + " at " + tower.getPosition();
    }
}