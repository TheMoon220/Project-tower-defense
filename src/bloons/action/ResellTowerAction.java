package bloons.action;

import bloons.board.Board;
import bloons.tower.Tower;
import bloons.utils.*;;
public  class  ResellTowerAction implements Action {

      private final Tower tower;
      /**
     * Constructor
     * @param tower the tower to buy (already configured with its cost)
     */
    public ResellTowerAction(Tower tower) {
        this.tower = tower;
    }

    /**
     * Perform the action on the board
     * @param board the game board
     * @return true if the action was successful, false otherwise
     */
    @Override
    public boolean execute(Board board){
        if (this.tower== null){
            return false ;
        }
    
      double totalcost= this.getCost();
      while (! this.tower.getAppliedEvolutions().isEmpty()){
        Evolution evo = this.tower.getAppliedEvolutions().pop();
        Integer  evoCost=  this.tower.getPossibleEvolutions().get(evo);
        if (evoCost != null){
            totalcost+= evoCost;
        }
        this.tower.removeEvolutionEffect(evo);
      }
      //give back to the player his tower cost
       Board.PLAYER.addCredit((int)Math.round(totalcost));
      //supprime la tour s=dans le plateau
      board.removeTower(this.tower);
    
      return true ;
    }

    
    
    /**
     * Returns a textual description of the action
     * @return description
     */
     @Override
    public String getDescription(){
        return "Resell " + this.tower;
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
