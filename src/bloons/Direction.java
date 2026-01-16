package bloons;

import java.util.Random;

public enum Direction {
    BOTTOM(0,-1),RIGHT(+1,0),DOWN(0,+1);
    private int dx;
    private int dy;
    private Direction(int dx,int dy){
        this.dx=dx;
        this.dy=dy;

    }
    /**
     * generate a random position :chose one position  one  among all position that are generated
     * @param p
     * @return
    
    */
    public Position generateNeighbor(Position p){
        Random random=new Random(); 
        int n=random.nextInt(3);
        Direction B= values()[n];
      return new Position(B.dx+p.getX(), B.dy+p.getY());
    }

    

}
