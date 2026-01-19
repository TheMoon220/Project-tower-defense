package bloons.utils;

import java.util.Random;
import bloons.*;

/** an enumeration for the object Direction */
public enum Direction {
    DOWN(0,+1),RIGHT(+1,0),TOP(0,-1);

    /** an attribute dx that represente the axis of the abscisses */
    private int dx;
    /** an attribute dy that represente the axis of the orders */
    private int dy;

    /** 
     * a private constructor for the enumerate class Direction
     * @param dx x-axis
     * @param dy y-axis
     */
    private Direction(int dx,int dy){
        this.dx=dx;
        this.dy=dy;
    }

    /**
     * generate a random position :chose one position  one  among all position that are generated
     * @param p a given position
     * @return a new position 
    */
    public Position generateNeighbor(Position p){
        Random random=new Random(); 
        int n=random.nextInt(3);
        Direction d= values()[n];

        return new Position(d.dx+p.getX(), d.dy+p.getY());
    }  
}
