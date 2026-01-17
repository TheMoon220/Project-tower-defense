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
   
     Random r=new Random();
    int n=r.nextInt(height);
    Position p=new Position(0, n);
    path.add(p);
    System.out.println("valide"+p.getX()+" "+p.getY());
    while (p.getX()<width){

      p=this.chooseValidNeighborPosition(p);
      this.path.add(p);
      if(path.contains(p)){
         System.out.println("valide"+p.getX()+" "+p.getY());
        
      }
     


    }
    }




public boolean isValid(Position P){

    return P.getY()>0 && P.getY()<this.height && !path.contains(P);
}

public Position chooseValidNeighborPosition(Position p){
   Position p2=Direction.TOP.generateNeighbor(p);
   while (!isValid(p2)){
   
    p2=Direction.TOP.generateNeighbor(p);

   }
   return p2;

}

    
}
