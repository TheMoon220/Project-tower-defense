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
    private int currentCellIndex ; // la première  case du chemin
    //constuctor of Balloon
    public Balloon(Position position, Level level,double  speed ){
        this.position = position;
        this.level = level;
        this.speed= speed;
        this.health= chooseHealth(level);
        this.currentCellIndex=0;
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
    /**
     *  Advances the balloon within its current cell based on its speed.
     * Calls checkNextCell() if the edge of the cell is reached to move
     * to the next cell in the path.
     */
     public  void advancePosition(){
        this.position.setX( this.position.getX() + this.speed);
        this.position.setY(this.position.getY()+this.speed);
         if (this.position.getX()>0.9  || this.position.getY()>0.9){
            checkNextCell();
            
        }



    }

    /**
     * Checks whether the balloon has reached the end of its path.
     * @return true if the balloon has completed its trajectory, false otherwise
     */
    public boolean checkEndOfPath(){
        if 
 
    }

    /**
     *  Moves the balloon to the next cell 
     */
    public void checkNextCell(){
        currentCellIndex++;  
          
    }
   

    /**
     * moove the ballon according to its speed 
     * @param b
     */
    public void moveBalloon(Position p){
        
 
        
    }

    public String toString(){
        return "this ballon has a position "+ this.position +"a level"+ this.level+ "a speed" + this.speed ;
    }

}