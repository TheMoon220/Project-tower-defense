package bloons;
import java.util.List;
import bloons.*;
import bloons.utils.*;
//class Balloon
public class Balloon {
    // path of the balloon
     private List<Position> path;
    // an attribute Position, that represent the ballon's position
    private   Position position;
    // an attribute level, that represent the ballon's level
    private  Level level ;
    // an attribute health, that represent the ballon's health
    private  int health;
    // an attribute speed, that represent the ballon's speed
    private double speed ;
    private int currentCellIndex ; // la première  case du chemin
    // progression in  the cell
    private double progress;
    //constuctor of Balloon
    public Balloon(Position position, Level level,double  speed ){
        this.position = position;
        this.level = level;
        this.speed= speed;
        this.health= level.getResistance();
        this.currentCellIndex=0;
        this.progress=0.0;
        
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
    public void setHealth() {
        this.health--; 
    }

    /** check if the balloon is destroy 
     * @return true if the ballon is destroy
    */
    public boolean isDestroyed() {
        return health <= 0;
    }

     /**
     *  Moves the balloon to the next cell 
     */
    public void checkNextCell(){
        while (progress >= 1.0 && currentCellIndex < path.size() - 1) {
            progress -= 1.0;  // on remet le progress à 0 pour dire qu'il est dans une nouvelle cellule 
            currentCellIndex++;
        } 
          
    }
    private void updateBalloonPosition() {
        Position currentPosition = path.get(currentCellIndex);
        Position nextPosition = path.get(Math.min(currentCellIndex + 1, path.size() - 1));

        double dx = nextPosition.getX() - currentPosition.getX();
        double dy = nextPosition.getY() - currentPosition.getY();

        position.setX(currentPosition.getX() + dx * progress);
        position.setY(currentPosition.getY() + dy * progress);
    }
   
   
    /**
     * Checks whether the balloon has reached the end of its path.
     * @return true if the balloon has completed its trajectory, false otherwise
     */
    public boolean checkEndOfPath(){
        return currentCellIndex >= path.size() - 1 && progress>=1.0;
 
    }

   
    /*
    *representztion of the ballon with a attribute
     */
    public String toString(){
        return "this ballon has a position "+ this.position +"a level"+ this.level+ "a speed" + this.speed ;
    }

}
