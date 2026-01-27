package bloons.board;

import bloons.*;
import java.util.*;
import bloons.utils.Direction;

/** the object ClassicalBoard for the board with a defnine path */
public class ClassicalBoard extends Board {
    /** an attribut path, a empty list of positions */
    private List<Position> path = new ArrayList<>();
    
    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     */
    public ClassicalBoard(int width, int height){
        super(width, height);
        this.calculPath();
    }

    /**
     * this method calculate the path of the first board
     * the methode generate at first a random Position on the first row of the grid(the brginning of the path) and add this first position on the path
     * classical board
     */
    @Override
    public void calculPath(){
   
      Random r=new Random();
      int n=r.nextInt(height);
      Position p=new Position(0, n);
      //this.path.add(p);
      while (p.getX()<width){
      this.path.add(p);

         p=this.chooseValidNeighborPosition(p);
         //this.path.add(p);
      }
    }

    /**
     * an method for check if a given position is valid or not as the same time the method checks if path not  contains position
     * @param P the position to check.
     * @return true if the position is valid otherwise false.
     */
    public boolean isValid(Position P){
       return P.getY()>0 && P.getY()<this.height && !path.contains(P);
    }

    /**
     * this method choose a position valid by a givin position if the genrated position is not in the grid the one other position w'll
     * be genrated and then when the position is in grid it is returned
     * @param p the position 
     * @return p2 a valid position
     */
    public Position chooseValidNeighborPosition(Position p){
       Position p2=Direction.generateNeighbor(p);
       while (!isValid(p2) || p.getX()>p2.getX()){
          p2=Direction.generateNeighbor(p);
       }
       return p2;
    }

    /**
     * get the path
     * @return a list of path
     */
    @Override
    public List<Position> getPath(){
        return this.path; 
    }
}
