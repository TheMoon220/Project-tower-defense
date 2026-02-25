package bloons.main;

import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import java.util.ArrayList;
import java.util.List;


public class Livrable3a {
    public static void main(String[] args) throws InterruptedException{

        if(args.length != 3){
            System.out.println("Exactly tree arguments are required");
            return;
        }

        int width;
        int height;
        int nbBalloons;
        try{
            width = Integer.parseInt(args[0]);
            height = Integer.parseInt(args[1]);
            nbBalloons = Integer.parseInt(args[2]);
        } catch(NumberFormatException e){
            System.out.println("Les arguments doivent etre des entiers");
            return;
        }
        
        System.out.println("=== Livrable 3a: Classical Board ===");
        System.out.println("Board size: " + width + "x" + height);
        System.out.println("Nombre de ballons " + nbBalloons);
        System.out.println();

        Board board = new ClassicalBoard(width, height);
        board.generateAllballoons(nbBalloons);
        System.out.println();
        board.displayBoard();
        System.out.println();
        board.displayPath();
        List <Balloon> balloons=board.getAllballoons();
        List <Tower> towers= board.generateRandomPositionTowers();
        for (Tower tower : towers) {
              tower.addBalloons(balloons);
           } 

        System.out.println("\n=== run simulation");
        long deltaTime = 100;
        long start =System.nanoTime();

        while(!balloons.isEmpty()){
            long currentTime = (System.nanoTime()-start)/1000000;
            System.out.println();
            System.out.println("time: " + currentTime + " ms");
            //tours attaquent
            //board.processTowers(towers, currentTime);
            //deplacement des ballons
            List<Balloon> toRemove = new ArrayList<>();
            for(int i = 0; i < balloons.size(); i++){
                Balloon balloon = balloons.get(i);
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

        System.out.println("\n=== All balloons finished ===");
        System.out.println("Total simulation time: " +(System.nanoTime()-start)/1000000);
         
     
}
}
