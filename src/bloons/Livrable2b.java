package bloons;

import bloons.board.*;
import bloons.utils.*;
import java.util.*;

/** the object Livrable2b, the main programm */
public class Livrable2b {
    public static void main(String[] args){
        // check arguments
        if(args.length != 3){
            System.out.println("for use it: java -classpath classes bloons.Livrable2b width height numPath");
            return;
        }

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int numPaths = Integer.parseInt(args[2]);

        System.out.println("=== Livrable 2b: Random Board ===");
        System.out.println("Board size: " + width + "x" + height);
        System.out.println("Number of paths: " + numPaths);
        System.out.println();

        RandomBoard board = new RandomBoard(width, height);
        board.generatePaths(numPaths);
        System.out.println("the board without any paths");
        board.displayBoard();
        System.out.println();

        List<Balloon> balloons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < numPaths; i++){
            //double speed = 0.01 + random.nextDouble() * 0.02; 
            Balloon balloon = board.createBalloonForPath(i, Level.genearaLevel());
            balloons.add(balloon);

            System.out.println(
                "Balloon " + i + 
                " created with speed " + String.format("%.4f", balloon.getSpeed())
            );
        }

        System.out.println("\n=== run simulation");
        long time = 0;
        long deltaTime = 100;
        while(!balloons.isEmpty()){
            board.displayBoard(balloons);
            System.out.println();
            System.out.println("time: " + time);
            for(int i = 0; i < balloons.size(); i++){
                Balloon b = balloons.get(i);
                System.out.println(
                    "Balloon " + i + " at (" + 
                    String.format("%.2f", b.getPosition().getX()) + ", " + 
                    String.format("%.2f", b.getPosition().getY()) + ")"
                );
            }
            System.out.println();

            List<Balloon> toRemove = new ArrayList<>();
            for(int i = 0; i < balloons.size(); i++){
                Balloon balloon = balloons.get(i);
                balloon.moveBallon();
                if(balloon.checkEndOfPath()){
                    System.out.println(
                        "Balloon " + i + " exited at time: " + time
                    );
                    toRemove.add(balloon);
                }
            }

            balloons.removeAll(toRemove);
            time += deltaTime;
        }
        System.out.println("\n=== All balloons finished ===");
        System.out.println("Total simulation time: " + time);
    }
}
