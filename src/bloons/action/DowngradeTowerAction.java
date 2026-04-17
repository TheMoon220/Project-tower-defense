package bloons.action;

import bloons.board.Board;
import bloons.tower.Tower;
import bloons.utils.Evolution;

/**
 * Action to remove an upgrade (downgrade)
 */
public class DowngradeTowerAction implements Action {
    /** the tower */
    private final Tower tower;
    
    /**
     * Constructor
     * @param tower the tower whose evolution we want to remove
     */
    public DowngradeTowerAction(Tower tower) {
        this.tower = tower;
    }
    
    /**
     * Perform the action on the board
     * @param board the game board
     * @return true if the action was successful, false otherwise
     */
    @Override
    public boolean execute(Board board) {
        // Vérifier que la tour est sur le plateau
        if (!board.getAllTowers().contains(tower)) {
            System.out.println("Tower " + tower + " is not on the board!");
            return false;
        }
        
        // Vérifier que la tour a des évolutions
        if (tower.getAppliedEvolutions().isEmpty()) {
            System.out.println(tower.getClass().getSimpleName() + " has no evolutions to remove!");
            return false;
        }
        
        // get the last evolution
        Evolution lastEvolution = tower.getAppliedEvolutions().peek();
        // Reimbursement is usually partial (e.g., 50% of the cost)
        int refund = (int) (tower.getPossibleEvolutions().get(lastEvolution) * 0.5);
        
        // remove evolution
        tower.removeEvolution();
        Board.PLAYER.addCredit(refund);
        
        System.out.println("Removed evolution " + lastEvolution + " from " + 
                         tower.getClass().getSimpleName() + " at " + tower.getPosition() +
                         ". Refund: " + refund + ". New balance: " + Board.PLAYER.getCredit());
        return true;
    }
    
    @Override
    public String getDescription() {
        return "Downgrade " + tower.getClass().getSimpleName() + " at " + tower.getPosition();
    }

    /**
     * Returns the cost of the action (if applicable)
     * @return the cost, or 0 if the action has no cost
     */
    @Override
    public int getCost(){
        return 0;
    }
}