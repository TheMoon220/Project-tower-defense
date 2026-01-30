package bloons.board;

import bloons.*;
import bloons.utils.*;
import java.util.*;

/** the object RandomBoard the second board */
public class RandomBoard extends Board {

    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     */
    public RandomBoard(int width, int height){
        super(width, height);
        this.calculPath();
    }

    /** a method for calculate the path (horizontal or vertical) in the board*/
    @Override
    public void calculPath(){
      this.getPath().clear();
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
     * a method that allows the appearance of a balloon
     * @param level the level of the balloon
     */
    public Balloon spawnBalloon(Level level, double speed){
       Random random = new Random();
       int side = random.nextInt(4);

       double startX , startY;
       List<Position> straightPath = new ArrayList<>();

       switch(side){
          case 0: //top to down
            startX = random.nextInt(this.width);
            for(int y = 0; y < this.height; y++){
              straightPath.add(new Position(startX, y));
            }
            break;
          case 1: //down to top
            startX = random.nextInt(this.width);
            for(int y = this.height - 1; y >= 0; y--){
              straightPath.add(new Position(startX, y));
            }
            break;
          case 2: //left to right
            startY = random.nextInt(this.height);
            for(int x = 0; x < this.width; x++){
              straightPath.add(new Position(x, startY));
            }
            break;
          default: // right to left
            startY = random.nextInt(this.height);
            for(int x = this.width - 1; x >= 0; x--){
              straightPath.add(new Position(x, startY));
            }

      }
       
      Balloon balloon = new Balloon(straightPath.get(0), level, speed);
      balloon.setTrajectory(straightPath);
      return balloon;
}
}