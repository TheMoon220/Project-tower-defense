package bloons;

public class Cell {

    private Position pos;

    /**
     * Builds a cell object with his position
     * @param pos a position of cell
     */
    public Cell(Position pos){
        this.pos = pos;
    }

    /** the position of cell 
     * @return the position of cell 
     */
    public Position getPos() {
        return this.pos;
    }
}
