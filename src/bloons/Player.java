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
   */
  public Player(){
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
  public void addCredit(){
    this.credit += PROFIT;
  }

  /**
   * decrease the player's life
   */
  public void loseLife(){
    this.health--;
  }

  /**
   * remove the old amount 
   * @param amnt the new amount
   */
  public void removeCredit(int amnt){
    this.credit -= amnt;
  }

  /**
   * check if the player has enough credit
   * @param cost the cost of a tower
   * @return true when he has credit otherwise false
   */
  public boolean canAfford(int cost){
    return this.credit >= cost;
  }

  /**represente a player to String
   *@return a stringg of player
  */
  @Override
  public String toString(){
    return "Player credits: "+this.credit + "\n" + "Player lives: " + this.health + "\n";
  }
}
