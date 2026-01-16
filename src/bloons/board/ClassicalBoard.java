package bloons.board;

import java.util.*;

import bloons.*;


public class ClassicalBoard extends Board {
    
    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     */
    public ClassicalBoard(int width, int height){
        super(width, height);
    }

    public void calculPath(){
        paths(Direction.TOP);

    }




   /**
    * generate a position
    * @param direction
    */
    private void paths(Direction direction){
    Random r=new Random();
    int n=r.nextInt(width);
    Position p=new Position(n, 0);
    path.add(p);
    while (p.getX()<height){

      p=direction.generateNeighbor(p);
      while(this.path.contains(p) && p.getY()<width){
         p=direction.generateNeighbor(p);
        
      }
      this.path.add(p);


    }
}

    
}
