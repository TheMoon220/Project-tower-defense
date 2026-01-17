package bloons;
import java.util.ArrayList;
import java.util.List;
public abstract class Board {
    /** an attribute width, that represent the board's width */
    protected int width;
    /** an attribute height, that represent the board's height */
    protected int height;
    /** an attribute grid, that represent the cells in our board */
    protected Cell[][] grid;
    /** an attribute path, that represent the path for each board */
    protected List<Position> path = new ArrayList<>();

    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     * @exception WrongSizeException when the height or width isn't an integer
     */
    public Board(int width, int height){

        if(height <=0 || width <= 0) {
            throw new IllegalArgumentException("Invalide size, please try again !");
        }

        this.width = width;
        this.height = height;
        this.grid = new Cell[width][height];
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                grid[i][j] = new Cell(new Position(i, j));
            }
        }
    }
    /** an abstract method */
    public abstract void calculPath();
    
    /**
     * get the width of the board
     * @return the width of the board
     */
    public int getWidth() {
      return this.width;
    }

    /**
     * get the height of the board
     * @return the height of the board
     */
    public int getHeight() {
      return this.height;
    }

    /**
     * get the grid of the board
     * @return grid, the grid of the board
     */
    public Cell[][] getGridCells(){ //jai changé le nom pour que ça soit plus coherent
        return this.grid;
    }
    /**
     * get the cell in the board at the position p 
     * @param p the position p
     * @return the cell  a the position p in the board 
     */
    public Cell getCell(Position p) throws IndexOutOfBoundsException{  // j'ai ecrit cette fonction pour recuper la cellule a une position donnee
        int x=p.getX();
        int y= p.getY();
        if( x<0||x>=grid.length ||  y<0 || y>grid[0].length){
            throw new IndexOutOfBoundsException("the position is incorect");
        }
        return this.grid[x][y];
    }
    /**
     * get the path 
     * @return path, the path in the board
     */
    public List<Position> getPath(){
        return this.path;
    }

    /** display board */
    public void displayBoard(){
        System.out.print("     ");
        for (int x = 0; x < this.width; x++){
            // Chaque numéro prend exactement 2 caractères de large pour coller à "X "
            System.out.print((x % 10) + " "); 
        }
        System.out.println();

        for (int y = 0; y < this.height; y++) {
           // Numéro de ligne sur 2 chiffres + barre de séparation
           System.out.print(String.format("%2d | ", y));

           for (int x = 0; x < this.width; x++) {
              Position currentPos = new Position(x,y);
              if(this.getPath() != null && this.getPath().contains(currentPos))
                System.out.print("X ");
              else
                System.out.print(". ");
           }
           System.out.println();
        }
            
    }

    /** display the path */
    public void displayPath(){
        System.out.println("Path:");
        for (Position p : this.getPath()) {
            System.out.println("(" + p.getX() + "," + p.getY() + ")");
        }
        System.out.println();
    }
}

