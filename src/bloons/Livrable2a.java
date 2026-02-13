package bloons;

import java.util.ArrayList;
import java.util.List;

import bloons.balloon.Balloon;
import bloons.board.Board;
import bloons.board.ClassicalBoard;

public class Livrable2a {
   
     public static void main(String[] args) throws InterruptedException{

        if(args.length != 3){
            System.out.println("Exactement trois arguments sont recquis en ligne de commande");
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

        System.out.println("=== Livrable 2a: Classical Board ===");
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

        System.out.println("\n=== run simulation");
        long time = 0;
        long deltaTime = 100;
         long start =System.nanoTime();
        while(!balloons.isEmpty()){
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
            Thread.sleep(deltaTime);
        }

        System.out.println("\n=== All balloons finished ===");
        System.out.println("Total simulation time: " +(System.nanoTime()-start)/1000000);
        System.out.println("Total simulation time: " +time);

     }
} 