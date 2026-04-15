package bloons.board;
import bloons.*;
import bloons.balloon.Balloon;
import bloons.tower.*;
import bloons.utils.*;
import java.util.*;

/** the object Board an abstract class for our game */
public abstract class Board {
    /** an attribute width, that represent the board's width */
    protected int width;
    /** an attribute height, that represent the board's height */
    protected int height;
    /** an attribute grid, that represent the cells in our board */
    protected Cell[][] grid;
    /** the attribute Allballoons on the board */
    protected List<Balloon> Allballoons ;
    /** the list of towers on the board */
    protected List<Tower> allTowers;
    /** the evoluted towers on the board */
    protected List<Tower> evolutedTowers;
    /** the player */
    public static Player PLAYER;


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

        PLAYER = new Player();
        this.width = width;
        this.height = height;
        this.grid = new Cell[width][height];
        this.Allballoons = new ArrayList<>();
        this.allTowers = new ArrayList<>();
        this.evolutedTowers = new ArrayList<>();
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
        this.Allballoons.clear();
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
    * @param i the index 
    * @param l the balloon level
    * @return a balloon 
    */
    public abstract Balloon createBalloonForPath(int i ,Level l);

    /** 
     * an abstraction for the method getPath 
     * @return a list of path
    */
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
     * generate two random towers of each type of Towers
     * @return a list of towers
     */
    public abstract List<Tower> generateRandomPositionTowers();

   /**
    * show how the towers attack the balloons on the board
    * @param towers the tower
    * @param tmp the current time
    * @throws InterruptedException an exception when the tmp don't match
    */
   public void processTowers(List<Tower> towers, long tmp) throws InterruptedException {
      for (Tower tower : towers) {
        tower.getAllBalloonsInRange();
        List<Balloon> inRange = tower.getBalloonsInRange();
        if (!inRange.isEmpty()) {
            Balloon target = tower.getBalloonClosestToExit();
            int healthBefore = target.getHealth();
            double speedBefore = target.getSpeed();
            if(target == null) continue;
            tower.attackBallon(target, tmp);
            if (target.getHealth() < healthBefore || target.getSpeed() != speedBefore) {
                System.out.println(tower + " shoots at Balloon at " + target.getPosition());
            }
            if (target.getHealth() < healthBefore) {
                if(target.getHealth() < 0){
                   target.setHealth(0);
                }
                System.out.println("time: " + tmp + " ms - Balloon touched (health: " + target.getHealth() + ")");
            }
            if (target.getHealth() <= 0) {
                System.out.println("time: " + tmp + " ms - Balloon destroyed !");
            }
            if (target.getSpeed() == 0 && speedBefore > 0) {
                System.out.println("time: " + tmp + " ms - Balloon frozen !");
            }
            if (target.getSpeed() < speedBefore && target.getSpeed() > 0) {
                System.out.println("time: " + tmp + " ms - Balloon slowed !");
            }
            if (target.getSpeed() > 0 && speedBefore == 0) {
                System.out.println("time: " + tmp + " ms - Balloon restarted !");
            }
        }
      }
    }

    /**
     * Generates a valid position for placing a tower
     * @return a valid position
    */
    public abstract Position getValidTowerPosition();  

    /**
     * Checks if a position is already occupied by a tower
     * @param pos the position to check
     * @return true if a tower is already present
    */
    public boolean isPositionOccupiedByTower(Position pos) {
      for (Tower t : allTowers) {
        if (t.getPosition().equals(pos)) {
            return true;
        }
      }
      return false;
    }

    /**
     * evolute one towers in board
     */
    public void EvoluteOneTower(){
        Random random = new Random();
        int i = random.nextInt(this.allTowers.size());
        Tower tower = this.allTowers.get(i);
        while (this.evolutedTowers.contains(tower) && !tower.canBeEvolute()) {
            i = random.nextInt(this.allTowers.size());
            tower = this.allTowers.get(i);
        }
        tower.putEvolutions();
        this.evolutedTowers.add(tower);
    }

    /**
     * remove evolution for one tower in board
     */
    public void removeEvolutionForOneTower(){
        Random random = new Random();
        int i = random.nextInt(this.evolutedTowers.size());
        Tower tower = this.evolutedTowers.get(i);
        tower.removeEvolution();
        this.evolutedTowers.remove(i);
    }

    /**
     * get all the towers on the board
     * @return the list of tours
    */
    public List<Tower> getAllTowers() {
      return this.allTowers;
    }

    /**
     * get the towers that have upgrades
     * @return the list of advanced towers
    */
    public List<Tower> getEvolutedTowers() {
      return this.evolutedTowers;
    }
}