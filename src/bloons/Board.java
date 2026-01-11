package bloons;

public abstract class Board {
    
    protected int width;
    protected int height;
    protected Cell[][] grid;

    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     */
    public Board(int width, int height){
        this.width = width;
        this.height = height;
        this.grid = new Cell[width][height];
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                grid[i][j] = new Cell(new Position(i, j));
            }
        }
    }

}
