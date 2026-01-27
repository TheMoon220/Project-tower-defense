package bloons;
import bloons.utils.*;
//class Balloon
public class Balloon {
    // an attribute Position, that represent the ballon's position
    private   Position position;
    // an attribute level, that represent the ballon's level
    private  Level level ;
    // an attribute health, that represent the ballon's health
    private  int health;
    // an attribute speed, that represent the ballon's speed
    private double speed ;
    //constuctor of Balloon
    public Balloon(Position position, Level level,double  speed ){
        this.position = position;
        this.level = level;
        this.speed= speed;
        this.health= chooseHealth(level);
    }  
    /**
     * return the level of this balloon
     * @return level
     */
    public Level getLevel(){
        return this.level;
    }
    /**
     * the position of this balloon
     * @return the position
     */
    public Position getPosition(){
        return this.position;
    }
    /**
     * return the speed of this balloon
     * @return the speed 
     */
    public double getSpeed(){
        return this.speed;
    }

    /**
     * the health of this health
     * @return
     */
    public int getHealth(){
        return this.health;
    }
    /**
     * set the health with the health in param
     * @param health the health 
     */
    public void setHealth(int health) {
        this.health = health-1; 
    }
     /**
      * choose the health of the ballon depending on the level
      * @param l the level
      * @return the corresponding  health 
      */
    public int chooseHealth(Level l){
        if (l== Level.NIV1){
           return 1; 
        }
        if (l== Level.NIV2){
           return 2;
        }
        return 4;
    }

    public boolean chechEndOfPath(){

    }

    public  void advancePosition()

    /**
     * moove the ballon according to its speed 
     * @param b
     */
    public void moveBalloon(Position p){
        

        
    }

}