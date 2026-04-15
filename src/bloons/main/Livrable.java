package bloons.main;
import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import java.util.*;

/** Abstract class Livrable for the base simulation */
public abstract class Livrable {
    
    /** Default constructor */
    public Livrable() { }

    /**
     * Create the appropriate board type.
     * @param width the width of the board 
     * @param height the height of the board 
     * @param param the number of balloons or number of paths
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
     * Get the towers to use during the simulation.
     * Can be overridden by Livrable5 to use actions.
     * @param board the board
     * @param param the parameter
     * @return list of towers
     */
    protected List<Tower> getTowers(Board board, int param) {
        return board.generateRandomPositionTowers();
    }

    /**
     * Apply evolution or devolution for a round.
     * Can be overridden by Livrable5 to use actions.
     * @param board the board
     * @param round the round number (1-10)
     */
    protected void applyEvolutionForRound(Board board, int round) {
        if(round <= 5){
            board.EvoluteOneTower();
        } else {
            board.removeEvolutionForOneTower();
        }
    }

    /**
     * Display the game state during a round.
     * Can be overridden by Livrable5 for simplified display.
     * @param board the board
     * @param currentTime current time in ms
     * @param balloons list of balloons
     */
    protected void displayDuringRound(Board board, long currentTime, List<Balloon> balloons) {
        System.out.println();
        System.out.println("time: " + currentTime + " ms");
        if(board instanceof RandomBoard){
            RandomBoard rb = (RandomBoard) board;
            rb.displayBoard(balloons);
        } else {
            board.displayBoard();
        }
    }

    /**
     * Main method to run the program
     * @param args command line arguments
     * @throws InterruptedException if error occurs
     */
    public void run(String[] args) throws InterruptedException {
        if(args.length != 3){
            System.out.println("Usage: java -classpath classes bloons.main.Livrable5 width height nbBalloons");
            return;
        }
        try {
            int width = Integer.parseInt(args[0]);
            int height = Integer.parseInt(args[1]);
            int param = Integer.parseInt(args[2]);

            if(height < 5 && width < 5){
                throw new IllegalArgumentException("Size must be at least 5x5!");
            }
            
            System.out.println("Board size: " + width + "x" + height);
            System.out.println();

            Board board = createBoard(width, height, param);
            initBoard(board, param);
            
            // Get towers (overridable method)
            List<Tower> towers = getTowers(board, param);
            
            for(int round = 1; round <= 10; round++) {
                System.out.println("\n=== Round " + round + " ===");
                
                // Apply evolutions (overridable method)
                applyEvolutionForRound(board, round);
                
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
                    
                    // Display during round (overridable method)
                    displayDuringRound(board, currentTime, balloons);
                    
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
                System.out.println("=== Round " + round + " finished ===");
            }
        } catch(NumberFormatException e){
            System.out.println("Arguments must be integers");
        }
    }
}