package bloons;

import java.util.Objects;

/** classe Position */
public class Position {
    private double x;
    private double y;

    /**
     * Builds a position with coordonates
     * @param x coordonate x
     * @param y coordonate y
     */
    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * get the cordonnate x
     * @return the cordonnate x
     */
    public double getX(){
        return this.x;
    }

    /**
     * get the cordonnate y
     * @return the cordonnate y
     */
    public double getY(){
        return this.y;
    }
    /**
     * set the x with the position x in param
     * @param s the new x 
     */
    public void setX(double s){
        this.x=s;
    }
     /**
     * set the y with the position i in param
     * @param i the new y
     */
    public void setY(double i) {
        this.y = i;
    }
    /**
     * @param o an object
     * @return if the position and the other object are equals
     */
    public boolean equals(Object o){
        if (o instanceof Position){
            Position other = (Position)o;
            return this.x==other.x && this.y==other.y;
        }
        else{
            return false;
        }
    }

    /**
     * an methode for the hashcode
     * @return the hash
     */
    @Override
    public int hashCode() {
      return Objects.hash(this.x, this.y);
    }

    /** 
     * a descrition for the position
     * @return string chain
     */
    @Override
    public String toString() {
      return "(" + (int)this.x + ", " + (int)this.y + ")";
    }
}
