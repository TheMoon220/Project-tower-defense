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

            Board board = createBoard(width, height, param);

            initBoard(board, param);

            List<Balloon> balloons = board.getAllballoons();
            List<Tower> towers = board.generateRandomPositionTowers();

            for (Tower tower : towers) {
                tower.addBalloons(balloons);
            }

            long deltaTime = 100;
            long start = System.nanoTime();

            while(!balloons.isEmpty()){

                long currentTime = (System.nanoTime() - start) / 1000000;

                board.processTowers(towers, currentTime);

                List<Balloon> toRemove = new ArrayList<>();

                for(Balloon balloon : balloons){

                    if(balloon.isDestroyed()){
                        toRemove.add(balloon);
                        continue;
                    }

                    balloon.moveBallon();

                    if(balloon.checkEndOfPath()){
                        toRemove.add(balloon);
                    }
                }

                balloons.removeAll(toRemove);

                Thread.sleep(deltaTime);
            }

            System.out.println("Simulation finished");

        } catch(NumberFormatException e){
            System.out.println("Arguments must be integers");
        }
    }
}

    