package bloons.board;

import  bloons.utils.*;

import bloons.*;
import bloons.balloon.Balloon;
import bloons.tower.*;
import bloons.tower.projectileTower.*;

import java.util.*;

/** the object Board an abstract class for our game */
public abstract class Board {
    /** an attribute width, that represent the board's width */
    protected int width;
    /** an attribute height, that represent the board's height */
    protected int height;
    /** an attribute grid, that represent the cells in our board */
    protected Cell[][] grid;
    protected List<Balloon> Allballoons ;

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

    /** 
     * ganerate balloons with given a parameter
     * @param n an integer
    */
    public void generateAllballoons(int n){
        for(int i = 0; i < n; i++){
            Balloon balloon =createBalloonForPath(i, Level.generateLevel());
            Allballoons.add(balloon);
            System.out.println(
                "Balloon " + i + 
                " speed : " + balloon.getSpeed() + " helth : " + balloon.getHealth()
            );
        } 
    }
   /**
    * create a balloon for an specific path
    * @param i
    * @param l the balloon level
    * @return a balloon 
    */
    public abstract Balloon createBalloonForPath(int i ,Level l);
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
        if( x<0||x>=grid.length ||  y<0 || y>=grid[0].length){
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


    /** return la liste des ballons
     * @return la liste des ballons
     */
    public List<Balloon> getAllballoons() {
        return Allballoons;
    }

    /**
     * generate two random towers of each Towers
     * @return a list of towers
     */
   public List<Tower> generateRandomTowers(){
       List<Tower> towers = new ArrayList<>();
       Random rand = new Random();
       
       for (int i = 0; i < 2; i++){
          Position pos1 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos2 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos3 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos4 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos5 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos6 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos7 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));

          towers.add(new IceTower(400,100,Effect.IMMEDIAT,1500,pos1));
          towers.add(new SlowDownTower(500,100,Effect.IMMEDIAT,1500,pos2));
          towers.add(new BombTower(600,150,Effect.DISTANCE,1800,pos3,Projectile.BOMB));
          towers.add(new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos4, Projectile.DART));
          towers.add(new SniperMonkeyTower(500, Effect.IMMEDIAT, 2000, pos5, Projectile.POINTEDDART));
          towers.add(new SuperMonkeyTower(1200, 200, Effect.IMMEDIAT, 300, pos6, Projectile.VERYSHARPDART));
          towers.add(new TackShooterTower(350, 80, Effect.IMMEDIAT, 1200, pos7, Projectile.NEEDLE));
       }
       
       return towers;
   }

   /**
    * show how the towers attack the balloons on the board
    * @param towers the tower
    * @param tmp the current time
    * @throws InterruptedException an exception when the tmp don't match
    */
   public void processTowers(List<Tower> towers, long tmp) throws InterruptedException {
      //TO DO
   }
}