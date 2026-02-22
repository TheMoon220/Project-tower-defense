package bloons.utils;
import java.util.Random;
//the enum level
public enum Level {
    //the level1
    NIV1(1), 
    //the level2
    NIV2(2), 
    //the level3
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
     * @return the resistance 
     */
    public void setResistance(){
         resistance--;
    }
   /**
    * generate a random level
    * @return a level
    */
    public static Level generateLevel(){
        Random random=new Random(); 
        int n=random.nextInt(3);
        Level niv= values()[n];
        return niv;
    }
}
