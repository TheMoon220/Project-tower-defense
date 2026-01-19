package bloons.board;

import java.util.*;

import bloons.*;

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
     * @return path 
     */
    @Override
    public List<Position> getPath(){
        return new ArrayList<>();
    }
}
