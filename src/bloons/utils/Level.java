package bloons.utils;
import java.util.Random;
//the enum level
public enum Level {
    NIV1(1), 
    NIV2(2), 
    NIV4(4);
    

    private final int resistance ;

    private Level(int resistance){
        this.resistance= resistance;
    }
    public int getResistance(){
        return resistance;
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
