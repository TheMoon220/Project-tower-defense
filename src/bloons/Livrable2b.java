package bloons;

import bloons.balloon.Balloon;
import bloons.board.*;
import java.util.*;

/** the object Livrable2b, the main programm */
public class Livrable2b {
    public static void main(String[] args) throws InterruptedException{
        // check arguments
        if(args.length != 3){
            System.out.println("for use it: java -classpath classes bloons.Livrable2b width height numPath");
            return;
        }
        

        try{
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
           board.generateAllballoons(numPaths);
           List <Balloon> balloons=board.getAllballoons();

           System.out.println("\n=== run simulation");
    
           long deltaTime = 100;
           long start =System.nanoTime();

           while(!balloons.isEmpty()){
              long time = System.nanoTime();
              long tmp = (time - start) / 1000000;
              
              board.displayBoard(balloons);
              System.out.println();
              System.out.println("time: " + tmp + " ms");
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
                    long exit = (System.nanoTime() - start) / 1_000_000;
                    System.out.println(
                        "Balloon " + i + " exited at time: " + exit + " ms"
                    );
                    toRemove.add(balloon);
                }
              }

              balloons.removeAll(toRemove);
              //time += deltaTime;
              Thread.sleep(deltaTime);
            }
            long total = (System.nanoTime() - start) / 1_000_000;
            System.out.println("\n=== All balloons finished ===");
            System.out.println("Total simulation time: " + total);
        } catch(NumberFormatException e){
            System.out.println("Les arguments doivent etre des entiers");
        }
    }
}
