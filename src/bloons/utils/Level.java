package bloons.utils;
import java.util.Random;

/** the object Level an enumeration */
public enum Level {
    /** the level 3 */
    NIV1(1), 
    /** the level 2 */
    NIV2(2), 
   /** the level 2 */
    NIV4(4);
    
    //the resistance of the balloon
    private  int resistance ;
    //the constructor of the level
    private Level(int resistance){
        this.resistance= resistance;
    }
    /**
     * the resistance of the balloon 
     * @return the resistance 
     */
    public int getResistance(){
        return resistance;
    }
     /**
     * the resistance of the balloon 
     */
    public void setResistance(){
         resistance--;
    }
   /**
    * generate a random level
    * @return niv a level
    */
    public static Level generateLevel(){
        Random random=new Random(); 
        int n=random.nextInt(3);
        Level niv= values()[n];
        return niv;
    }
}