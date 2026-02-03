package bloons.board;

import bloons.*;
import bloons.utils.*;

import java.util.*;

/** the object RandomBoard the second board */
public class RandomBoard extends Board {
    private List<List<Position>> allPaths; //a list of positions

    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     */
    public RandomBoard(int width, int height){
        super(width, height);
        this.allPaths = new ArrayList<>();
    }

    /** a method for calculate the path (horizontal or vertical) in the board*/
    @Override
    public void calculPath(){
      this.allPaths.clear();
    }

    /**
     * get a empty path list
     * @return path a list of positions
    */
    @Override
    public List<Position> getPath(){
        return new ArrayList<>();
    }

    /**
     * Generate multiple paths
     * @param numPaths number of paths to generate
     */
    public void generatePaths(int numPaths){
        this.allPaths.clear();
        Random random = new Random();
        int i;
        for(i = 0; i < numPaths; i++){
            Direction[] directions = Direction.values();
            Direction direction = directions[random.nextInt(4)];
            List<Position> path = new ArrayList<>();
            double startX, startY;

            switch(direction){
                case DOWN: //top to down
                   startX = random.nextInt(this.width);
                   for(int y = 0; y < this.height; y++){
                      path.add(new Position(startX, y));
                   }
                   break;
                case TOP: //down to top
                   startX = random.nextInt(this.width);
                   for(int y = this.height - 1; y >= 0; y--){
                      path.add(new Position(startX, y));
                   }
                   break;
                case RIGHT: //left to right
                   startY = random.nextInt(this.height);
                   for(int x = 0; x < this.width; x++){
                      path.add(new Position(x, startY));
                   }
                   break;
                default: //right to left
                   startY = random.nextInt(this.height);
                   for(int x = this.width - 1; x >= 0; x--){
                      path.add(new Position(x, startY));
                   }
            }
            this.allPaths.add(path);
        }
    }

    /** 
     * get all generated paths
     * @return allPaths
     */
    public List<List<Position>> getAllPaths(){
       return this.allPaths;
    }

    /**
     * Get a specific path by index
     * @return the path 
     */
    public List<Position> getPathAt(int index){
        if(index < 0 || index >= this.allPaths.size()){
            throw new IllegalArgumentException("Invalid path index: " + index);
        }
        return this.allPaths.get(index);
    }

   /**
    * Create a balloon for a specific path
    * @param pathIndex 
    * @param level the level of the balloon
    * @param speed the speed of the balloon
    * @return a balloon
    */
   public Balloon createBalloonForPath(int pathIndex, Level level, double speed){
     List<Position> path = this.getPathAt(pathIndex);
     Balloon balloon = new Balloon(path.get(0), level, speed);
     balloon.setTrajectory(path);
     return balloon;
   }
}