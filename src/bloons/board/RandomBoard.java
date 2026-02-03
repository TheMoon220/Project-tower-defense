package bloons.board;

import bloons.*;
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
}