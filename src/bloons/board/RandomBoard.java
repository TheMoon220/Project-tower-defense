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
    public Balloon spawnBalloon(Level level){
       Random random = new Random();
       int side = random.nextInt(4);

       double x = 0, y = 0;
       Direction direction;
       switch(side){
          case 0: //haut
            x = random.nextInt(this.width);
            y = 0;
            direction = Direction.DOWN;
            break;
          case 1: //down
            x = random.nextInt(this.width);
            direction = Direction.TOP;
            y = this.height - 1;
            break;
          case 2: //left
            x = 0;
            y = random.nextInt(this.height);
            direction = Direction.RIGHT;
            break;
          default: // right
            x = this.width - 1;
            y = random.nextInt(this.height);
            direction = Direction.LEFT;
       }
       Position position = new Position(x, y);
       //return new Balloon(position,level,direction,this); // here this represente 'this board'
    }
}
