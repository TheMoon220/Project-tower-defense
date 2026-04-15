package bloons.board;

import bloons.*;
import bloons.balloon.Balloon;
import bloons.tower.*;
import bloons.tower.projectileTower.*;
import bloons.utils.*;
import java.util.*;

/** the object RandomBoard the second board */
public class RandomBoard extends Board {
   /** list of positions */
    private final List<List<Position>> allPaths; 

    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     */
    public RandomBoard(int width, int height){
        super(width, height);
        this.allPaths = new ArrayList<>();
    }

    /** a method for calculate the path (horizontal or vertical) in the board*/
    @Override
    public void calculPath(){
      this.allPaths.clear();
    }

    /**
     * get a empty path list
     * @return path a list of positions
    */
    @Override
    public List<Position> getPath(){
        return new ArrayList<>();
    }

    /**
     * an methode for check if a path overlaps with existing paths
     * @param paths to check
     * @param usePositions the already used positions
     * @return true if the path overlap otherwise false
     */
    private boolean hasOverLap(List<Position> paths,  List<List<Position>> usedPositions){
      Set<Position> newPathSet = new HashSet<>(paths);
      for(List<Position> p: usedPositions){
         Set<Position> setPos = new HashSet<>(p);
         if(setPos.equals(newPathSet)){
            return true;
         }
      }

      return false;
    }

    /**
     * Generate multiple paths
     * @param numPaths number of paths to generate
     * @exception IllegalArgumentException when the numPaths it's exceed the size
     */
    public void generatePaths(int numPaths){
        int var = this.height + this.width;
        if(var <= numPaths){
           throw new IllegalArgumentException("the number must not exceed the size");
        }

        this.allPaths.clear();
        Random random = new Random();
        int i = 0;
        while(i < numPaths){
            Direction[] directions = Direction.values();
            Direction direction = directions[random.nextInt(4)];
            List<Position> path = new ArrayList<>();
            double startX, startY;

            switch(direction){
                case DOWN: //top to down
                   startX = random.nextInt(this.width);
                   for(int y = 0; y < this.height; y++){
                      path.add(new Position(startX, y));
                   }
                   break;
                case TOP: //down to top
                   startX = random.nextInt(this.width);
                   for(int y = this.height - 1; y >= 0; y--){
                      path.add(new Position(startX, y));
                   }
                   break;
                case RIGHT: //left to right
                   startY = random.nextInt(this.height);
                   for(int x = 0; x < this.width; x++){
                      path.add(new Position(x, startY));
                   }
                   break;
                default: //right to left
                   startY = random.nextInt(this.height);
                   for(int x = this.width - 1; x >= 0; x--){
                      path.add(new Position(x, startY));
                   }
            }
            
            if(!this.hasOverLap(path, this.allPaths)){
               this.allPaths.add(path);
               i++;
            }
        }
    }

    /** 
     * get all generated paths
     * @return allPaths
     */
    public List<List<Position>> getAllPaths(){
       return this.allPaths;
    }

    /**
     * Get a specific path by index
     * @param index the index
     * @return the path 
     */
    public List<Position> getPathAt(int index){
        if(index < 0 || index >= this.allPaths.size()){
            throw new IllegalArgumentException("Invalid path index: " + index);
        }
        return this.allPaths.get(index);
    }

   /**
    * Create a balloon for a specific path
    * @param pathIndex the index path
    * @param level the level of the balloon
    * @return a balloon
    */
   @Override
   public Balloon createBalloonForPath(int pathIndex, Level level){
     List<Position> path = this.getPathAt(pathIndex);
     List<Position> pathcopy = new ArrayList<>();
     for(Position p: path){
        pathcopy.add(new Position(p.getX(), p.getY()));
     }
     Balloon balloon = new Balloon(pathcopy.get(0), level);
     balloon.setTrajectory(pathcopy);
     return balloon;
   }

   /**
    * get all paths
    * @return all paths
    */
    public List<List<Position>> getAllPath(){
      return this.allPaths;
    }

    /**
     * generate two random towers of each Towers
     * @return a list of towers
     */
    @Override
    public List<Tower> generateRandomPositionTowers(){
       Random rand = new Random();
       
       for (int i = 0; i < 2; i++){
          Position pos1 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos2 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos3 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos4 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos5 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos6 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));
          Position pos7 = new Position(rand.nextInt(this.width), rand.nextInt(this.height));

          this.allTowers.add(new IceTower(400,100,Effect.IMMEDIAT,1500,pos1));
          this.allTowers.add(new SlowDownTower(500,100,Effect.IMMEDIAT,1500,pos2));
          this.allTowers.add(new BombTower(600,150,Effect.DISTANCE,1800,pos3,Projectile.BOMB));
          this.allTowers.add(new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos4, Projectile.DART));
          this.allTowers.add(new SniperMonkeyTower(500, Effect.IMMEDIAT, 2000, pos5, Projectile.POINTEDDART));
          this.allTowers.add(new SuperMonkeyTower(1200, 200, Effect.IMMEDIAT, 300, pos6, Projectile.VERYSHARPDART));
          this.allTowers.add(new TackShooterTower(350, 80, Effect.IMMEDIAT, 1200, pos7, Projectile.NEEDLE));
       }
       
       return this.allTowers;
   }

   /**
    * Display board with balloons
    * @param balloons a list of balloons to display
    */
   public void displayBoard(List<Balloon> balloons){
      System.out.print("     ");
      for (int x = 0; x < this.width; x++){
         System.out.print((x % 10) + " "); 
      }
        System.out.println();

      for(int y = 0; y < this.height; y++){
         System.out.print(String.format("%2d | ", y));
         for(int x = 0; x < this.width; x++){
            Position currentPos = new Position(x, y);
            char symbol = '.';
            for(List<Position> path : this.allPaths){
               if(path.contains(currentPos)){
                  symbol = 'X';
                  break;
               }
            }

            if(balloons != null){
               for(Balloon balloon : balloons){
                  int bx = (int) Math.round(balloon.getPosition().getX());
                  int by = (int) Math.round(balloon.getPosition().getY());
                  if(bx == x && by == y){
                     symbol = 'B';
                     break;
                  }
               }
            }
            System.out.print(symbol + " ");
         }
         System.out.println();
      }
   }

   /**
    * Generates a valid position for placing a tower
    * @return a valid position
   */
   @Override
   public Position getValidTowerPosition() {
      Random rand = new Random();
      Position p;
      do {
        p = new Position(rand.nextInt(width), rand.nextInt(height));
      } while (getPath().contains(p) || isPositionOccupiedByTower(p));
      return p;
   }
}