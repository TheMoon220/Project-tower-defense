package bloons.board;

import bloons.*;
import java.util.*;
import bloons.utils.Direction;


public class ClassicalBoard extends Board {
    
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
     * this method calculate the path of the first board, the
     * classical board
     */
    @Override
    public void calculPath(){
   
      Random r=new Random();
      int n=r.nextInt(height);
      Position p=new Position(0, n);
      this.path.add(p);
      //System.out.println("valide"+p.getX()+" "+p.getY());
      while (p.getX()<width){
         p=this.chooseValidNeighborPosition(p);
         this.path.add(p);
      }
    }

    /**
     * an method for check if a givin position is valid or not
     * @return true if the position is valid otherwise false.
     */
    public boolean isValid(Position P){
       return P.getY()>0 && P.getY()<this.height && !path.contains(P);
    }

    /**
     * this method choose a position valid by a givin position
     * @param p
     * @return p2 a valid position
     */
    public Position chooseValidNeighborPosition(Position p){
       Position p2=Direction.TOP.generateNeighbor(p);
       while (!isValid(p2)){
          p2=Direction.TOP.generateNeighbor(p);
       }
       return p2;
    }
}
