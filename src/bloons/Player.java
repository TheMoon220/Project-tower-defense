package bloons;

/** the object player */
public class Player {

    /** The profit of the player when a ballon have been broken */
    public static final int PROFIT = 10;
    private int health;
    private int credit ;
    /**
     * build an player with an health an credit 
     * @param health is the health that the player have 
     * @param credit the cretdit or pieces of the player
     */
    
       public Player(int health,int credit){
        this.credit=credit;
        this.health=health;
    }
/**
 * allow to get the player current health
 * @return the health of the player
 */
    public int getHealth(){
     return this.health;

    }
    /**
     * allow to get the current credit of the player
     * @return the credit
     */
    public int getCredit(){
        return this.credit;
    }

    /**
     * change the player credit by diminishing the number of credit
     */
  public void setCredit(){
    this.credit += PROFIT;
  }
  /**
    * change the player credit by diminishing the number of credit
   *
   */
  public void setHealth(){
    this.health--;
  }
/**represente a player to String
 *@return a stringg of player
 */
  public String toString(){
    return "Player(credit: "+this.credit + ",  health: "+this.health + ")";
  }
}
