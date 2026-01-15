package bloons;

import java.util.ArrayList;
import java.util.List;

import bloons.*;

/** the object Board an abstract class, for our game */
public abstract class Board {
    /** an attribute width, that represent the board's width */
    protected int width;
    /** an attribute height, that represent the board's height */
    protected int height;
    /** an attribute grid, that represent the cells in our board */
    protected Cell[][] grid;
    /** an attribute path, that represent the path for each board */
    protected List<Position> path = new new ArrayList<>();

    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     * @exception WrongSizeException when the height or width isn't an integer
     */
    public Board(int width, int height){

        if(height <=0 || width <= 0) {
            throw new WrongSizeException("Invalide size, please try again !");
        }

        this.width = width;
        this.height = height;
        this.grid = new Cell[width][height];
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                grid[i][j] = new Cell(new Position(i, j));
            }
        }
    }
    /** an abstract method */
    public abstract void calculPath();
    
    /**
     * get the width of the board
     * @return the width of the board
     */
    public int getWidth() {
      return this.width;
    }

    /**
     * get the height of the board
     * @return the height of the board
     */
    public int getHeight() {
      return this.height;
    }

}
