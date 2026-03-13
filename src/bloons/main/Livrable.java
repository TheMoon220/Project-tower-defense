package bloons.main;
import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import java.util.*;

public  abstract class Livrable {
    /**
     * Create the appropriate board type.
     * @param width the width of the board 
     * @param height the height of the board 
     * @param param  
     * @return
     */
    protected abstract Board createBoard(int width, int height, int param);


     /**
     * Initializes the board according to the simulation type.
     * @param board the board used for the simulation
     * @param param additional parameter for initialization
     */
    protected abstract void initBoard(Board board, int param);
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
            System.out.println("Board size: " + width + "x" + height);
            System.out.println();

            Board board = createBoard(width, height, param);
            initBoard(board, param);
            List<Balloon> balloons = board.getAllballoons();
            List<Tower> towers = board.generateRandomPositionTowers();
            for (Tower tower : towers) {
                tower.addBalloons(balloons);
            }
            System.out.println("\n=== run simulation");
            long deltaTime = 100;
            long start = System.nanoTime();

            while(!balloons.isEmpty()){

                long currentTime = (System.nanoTime() - start) / 1000000;
                
                System.out.println();
                System.out.println("time: " + currentTime+ " ms");
                if (board instanceof RandomBoard){
                    RandomBoard rb = (RandomBoard) board;
                    rb.displayBoard(balloons);
                }else{
                    board.displayBoard();
                }
                board.processTowers(towers, currentTime);

                List<Balloon> toRemove = new ArrayList<>();

                for(int i = 0; i < balloons.size(); i++){
                    Balloon balloon = balloons.get(i);
                    if(balloon.isDestroyed()){
                        toRemove.add(balloon);
                        continue;
                    }
                    balloon.moveBallon();
                    System.out.println(
                    "Balloon " + i + " at (" + 
                    String.format("%.2f", balloon.getPosition().getX()) + ", " + 
                    String.format("%.2f", balloon.getPosition().getY()) + ")"
                );
                    if(balloon.checkEndOfPath()){
                        System.out.println("Balloon " + i + " exited at time: " + currentTime);
                        toRemove.add(balloon);
                    }
                }
                balloons.removeAll(toRemove);
                Thread.sleep(deltaTime);
            }
            long total = (System.nanoTime() - start) / 1000000;
            System.out.println("\n=== All balloons finished ===");
            System.out.println("Total simulation time: " + total);
            System.out.println("Simulation finished");

        } catch(NumberFormatException e){
            System.out.println("Arguments must be integers");
        }
    }
}

    