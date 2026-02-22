package bloons.balloon;
import java.util.List;

import bloons.Position;
import bloons.utils.*;
import java.util.*;
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
    public Balloon(Position position, Level level){
        this.position = position;
        this.level = level;
        this.speed= randomChoiceSpeed();
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
        if (this.health>=1){
            this.health--; 
        }
        
    }

    /** check if the balloon is destroy 
     * @return true if the ballon is destroy
    */
    public boolean isDestroyed() {
        return health <= 0;
    }

    /**
     * Sets the path (trajectory) that the balloon will follow.
     * 
     * This method must be called after creating the balloon to provide it with
     * the path it will move along. It also resets the balloon's current cell
     * and progress along the cell to the beginning of the path.
     *
     * @param path the list of positions representing the trajectory for the balloon
     * @throws IllegalArgumentException if the path is null or empty
     */
    public void setTrajectory(List<Position> path) {
        if (path == null || path.isEmpty())
            throw new IllegalArgumentException("Chemin invalide");
        this.path = path;
        this.currentCellIndex = 0;
        this.progress = 0.0;
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
    /**
     * update the ballon's position with the information path , currentCellIndex
     */
    private void updateBalloonPosition() {
        Position currentPosition = path.get(currentCellIndex);
        Position nextPosition = path.get(Math.min(currentCellIndex + 1, path.size() - 1));

        double dx = nextPosition.getX() - currentPosition.getX();
        double dy = nextPosition.getY() - currentPosition.getY();

        position.setX(currentPosition.getX() + dx * progress);
        position.setY(currentPosition.getY() + dy * progress);
    }
    /**
     *  move  the balloon within its current cell based on its speed.
     * Calls checkNextCell() if the edge of the cell is reached to move
     * update the balloon's position with updateBalloon()
     * to the next cell in the path.
     */
     public  void moveBallon(){
        if (path == null || path.isEmpty() || checkEndOfPath() || isDestroyed()){
            return; 
        } 
        progress += speed;
        // Passage at the  next cell if progress >= 1
        checkNextCell();;
        // Calcul de la position réelle entre la cellule actuelle et la suivante
        updateBalloonPosition();
    }

   
    /**
     * Checks whether the balloon has reached the end of its path.
     * @return true if the balloon has completed its trajectory, false otherwise
     */
    public boolean checkEndOfPath(){
        return currentCellIndex >= path.size() - 1 && progress>=1.0;
 
    }
    /**
     * chooses a random  speed freom a predefined list
     * @return 
     */
    public double  randomChoiceSpeed(){
        Random random = new Random();
        double speeds[]=  {1.0,2.0 ,3.1};
        int i = random.nextInt(speeds.length);
        return speeds[i];

       }
   
    /*
    *representztion of the ballon with a attribute
     */
    public String toString(){
        return "this ballon has a position "+ this.position +"a level"+ this.level+ "a speed" + this.speed ;
    }
    /** return path
     * @return path
     */
    public List<Position> getPath() {
        return path;
    }
    /** return currentCellIndex
     * @return currentCellIndex
     */
    public int getCurrentCellIndex() {
        return currentCellIndex;
    }
    /**return progress
     * @return progress
     */
    public double getProgress() {
        return progress;
    }
    
    /**
     * set speed 
     * @param s the new speed
     */
    public void setSpeed(double s){
        this.speed = s;
    }
}
