package bloons;

/** the object player */
public class Player {

    /** The profit of the player when a ballon have been broken */
    public static final int PROFIT = 10;
    /** the credit of the player */
    public static final int CREDIT = 2500;
    /** the life of the player */
    public static final int HEALTH = 20;
    /** the variable health */
    private int health;
    /** the variable credit */
    private int credit ;
    /**
     * build an player with an health an credit 
     * @param health is the health that the player have 
     * @param credit the cretdit or pieces of the player
     */
    
       public Player(int health,int credit){
        this.credit = Player.CREDIT;
        this.health = Player.HEALTH;
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
   */
  public void setHealth(int health){
    if(health > 0)
      this.health--;
  }

  /**represente a player to String
   *@return a stringg of player
  */
  public String toString(){
    return "Player lives: "+this.credit + "\n" + "Player health: " + this.health + "\n";
  }
}
