package bloons;
/** classe Position */
public class Position {
    private int x;
    private int y;

    /**
     * Bulds a position with coordonates
     * @param x coordonate x
     * @param y coordonate y
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * get the cordonnate x
     * @return the cordonnate x
     */
    public int getX(){
        return this.x;
    }

    /**
     * get the cordonnate y
     * @return the cordonnate y
     */
    public int getY(){
        return this.y;
    }
    
}
