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
<<<<<<< HEAD
       this.path.clear(); 
=======
      this.getPath().clear();
    }
>>>>>>> d4f92107ed20dd4a021662d99c0a4f26654cea49

     /**
     * get a empty path list
     * @return path 
     */
    @Override
    public List<Position> getPath(){
        return new ArrayList<>();
    }
}
