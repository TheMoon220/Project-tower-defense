package bloons.board;

import java.util.ArrayList;
import java.util.List;

import bloons.*;

/** the object Board an abstract class for our game */
public abstract class Board {
    /** an attribute width, that represent the board's width */
    protected int width;
    /** an attribute height, that represent the board's height */
    protected int height;
    /** an attribute grid, that represent the cells in our board */
    protected Cell[][] grid;
     private List<Balloon> Allballoons 

    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     * @exception IllegalArgumentException when the height or width isn't an integer
     */
    public Board(int width, int height){

        if(height <=0 || width <= 0) {
            throw new IllegalArgumentException("Invalide size, please try again !");
        }

        this.width = width;
        this.height = height;
        this.grid = new Cell[width][height];
        this.Allballoons=new ArrayList<>();
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                grid[i][j] = new Cell(new Position(i, j));
            }
        }
    }
    /** an abstract method for calculate the path on the board*/
    public abstract void calculPath();

    /** an abstract method to keep the position of a path
     *  @return a list of position
    */

    public void generateAllballoons(int n){
        
    }
    public abstract List<Position> getPath();
    
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
        int x=(int) p.getX();//je l'ai cate en int pour tester
        int y= (int) p.getY();
        if( x<0||x>=grid.length ||  y<0 || y>grid[0].length){
            throw new IndexOutOfBoundsException("the position is incorect");
        }
        return this.grid[x][y];
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
        String text = this.getPath().isEmpty() ? "Not defined path yet, Beause it's depends to the bloons!" : "Path:";
        System.out.println(text);
        for (Position p : this.getPath()) {
            System.out.println("(" + p.getX() + "," + p.getY() + ")");
        }
        System.out.println();
    }
}

