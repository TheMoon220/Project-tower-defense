package bloons.board;

import bloons.*;
import bloons.balloon.Balloon;
import bloons.tower.*;
import bloons.tower.projectileTower.*;
import bloons.utils.*;
import java.util.*;


/** the object ClassicalBoard for the board with a defnine path */
public class ClassicalBoard extends Board {
    /** an attribut path, a empty list of positions */
    private List<Position> path = new ArrayList<>();
    
    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     */
    public ClassicalBoard(int width, int height){
        super(width, height);
        this.calculPath();
    }

    /**
     * this method calculate the path of the first board
     * the methode generate at first a random Position on the first row of the grid(the brginning of the path) and add this first position on the path
     * classical board
     */
    @Override
    public void calculPath(){
   
      Random r=new Random();
      int n=r.nextInt(height);
      Position p=new Position(0, n);
      //this.path.add(p);
      while (p.getX()<width){
      this.path.add(p);

         p=this.chooseValidNeighborPosition(p);
         //this.path.add(p);
      }
    }

    /**
     * an method for check if a given position is valid or not as the same time the method checks if path not  contains position
     * @param P the position to check.
     * @return true if the position is valid otherwise false.
     */
    public boolean isValid(Position P){
       return P.getY()>=0 && P.getY()<this.height && !path.contains(P);
    }

    /**
     * this method choose a position valid by a givin position if the genrated position is not in the grid the one other position w'll
     * be genrated and then when the position is in grid it is returned
     * @param p the position 
     * @return p2 a valid position
     */
    public Position chooseValidNeighborPosition(Position p){
       Position p2=Direction.generateNeighbor(p);
       while (!isValid(p2) || p.getX()>p2.getX()){
          p2=Direction.generateNeighbor(p);
       }
       return p2;
    }

    /**
     * get the path
     * @return a list of path
     */
    @Override
    public List<Position> getPath(){
        return this.path; 
    }
    
    /**
    * Create a balloon for a specific path
    * @param pathIndex the path 
    * @param level the level of the balloon
    * @return a balloon
    */
   @Override
   public Balloon createBalloonForPath(int pathIndex, Level level){

      Balloon balloon = new Balloon(this.path.get(0),level);
      balloon.setTrajectory(path);
      return balloon;
   }

   /**
     * generate two random towers of each Towers
     * @return a list of towers
   */
   @Override
   public List<Tower> generateRandomPositionTowers(){
       
       for (int i = 0; i < 2; i++){
          Position pos1 = generateValidPosition();
          Position pos2 = generateValidPosition() ;
          Position pos3 = generateValidPosition() ;
          Position pos4 = generateValidPosition() ;
          Position pos5 = generateValidPosition() ;
          Position pos6 = generateValidPosition() ;
          Position pos7 = generateValidPosition() ;

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
   

   private Position generateValidPosition() {
      Random rand=new Random();
      Position p=new Position(rand.nextInt(width),rand.nextInt(height)) ;
      while(InPath(p)){
         p=new Position(rand.nextInt(width),rand.nextInt(height)) ;
     }
     return p ;
   }
   /**
    * ccheck if the position p not in the path
    * @param p
    * @return true when position not in path
    */

   private boolean InPath(Position p) {
      for (Position p1:path){
         if(p.equals(p1)){
            return true ;
         }
      }
      return false ;
   }
}
