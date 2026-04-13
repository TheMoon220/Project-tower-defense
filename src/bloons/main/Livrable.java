package bloons.main;
import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import java.util.*;

/** the object Livrable an abstract class */
public  abstract class Livrable {
    /** the default constructor of the class livrable */
    public Livrable() { }

    /**
     * Create the appropriate board type.
     * @param width the width of the board 
     * @param height the height of the board 
     * @param param  the number of balloon for classical and number of paths for random
     * @return a board
     */
    protected abstract Board createBoard(int width, int height, int param);


     /**
     * Initializes the board according to the simulation type.
     * @param board the board used for the simulation
     * @param param additional parameter for initialization
     */
    protected abstract void initBoard(Board board, int param);

    /**
     * the methode for run the main programm
     * @param args the arguments
     * @exception InterruptedException when an error 
     */
    public  void run(String[] args) throws InterruptedException{
        // check arguments
        if(args.length != 3){
            System.out.println("for use it: java -classpath classes bloons.Livrable2b width height numPath");
            return;
        }
        try{

            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);
            int param = Integer.parseInt(args[2]);

            if(height < 5 && width < 5){
                throw new IllegalArgumentException("please try a again !");
            }
            
            System.out.println("Board size: " + width + "x" + height);
            System.out.println();

            Board board = createBoard(width, height, param);
            initBoard(board, param);
            List<Tower> towers = board.generateRandomPositionTowers();
            for(int manche = 1; manche <= 10; manche ++){
                System.out.println("\n=== Manche " + manche + " ===");
                if(manche <= 5){
                    board.EvoluteOneTower();
                }else{
                    board.removeEvolutionForOneTower();
                }
                System.out.println();
                board.generateAllballoons(param);
                List<Balloon> balloons = board.getAllballoons();
                for(Tower tower : towers){
                    tower.addBalloons(balloons);
                }

                long deltaTime = 100;
                long start = System.nanoTime();
                while(!balloons.isEmpty()){
                   long currentTime = (System.nanoTime() - start) / 1000000;

                   System.out.println();
                   System.out.println("time: " + currentTime+ " ms");
                   if(board instanceof RandomBoard){
                      RandomBoard rb = (RandomBoard) board;
                      rb.displayBoard(balloons);
                   }else{
                      board.displayBoard();
                   }

                   board.processTowers(towers, currentTime);
                   System.out.println();
                   List<Balloon> toRemove = new ArrayList<>();
                   for (int i = 0; i < balloons.size(); i++) {
                       Balloon balloon = balloons.get(i);
                       if(balloon.isDestroyed()){
                          toRemove.add(balloon);
                          continue;
                       }
                       
                       balloon.moveBallon();
                       if(balloon.checkEndOfPath()){
                          long exit = (System.nanoTime() - start) / 1000000;
                          System.out.println("Balloon " + i + " exited at time: " + exit + " ms");
                          toRemove.add(balloon);
                       }
                   }
                   balloons.removeAll(toRemove);
                   Thread.sleep(deltaTime);
                }
                System.out.println();
                System.out.println("=== Manche " + manche + " terminée ===");
                //long total = (System.nanoTime() - start) / 1000000;
                //System.out.println("\n=== All balloons finished ===");
                //System.out.println("Total simulation time: " + total);
            }

        } catch(NumberFormatException e){
            System.out.println("Arguments must be integers");
        }
    }
}
    