package bloons;

import bloons.board.*;
import java.util.Scanner;

public class MainLivrable1 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int h = 0, w = 0;

       if (args.length == 2) {
           try {
              w = Integer.parseInt(args[0]);
              h = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
              System.out.println("Error: Height and width must be integers.");
              return;
            }
       }else {
           System.out.println("No arguments provided. Please enter dimensions:");
           System.out.print("Width: ");
           w = sc.nextInt();
           System.out.print("Height: ");
           h = sc.nextInt();
        }

        try{
             Board classicalBoard = new ClassicalBoard(w,h);
             System.out.println("display classical board: " + classicalBoard.getWidth() + "X" + classicalBoard.getHeight());
             classicalBoard.displayBoard();
             classicalBoard.displayPath();
          
             Board randomBoard = new RandomBoard(w,h);
             System.out.println("display random board: " + randomBoard.getWidth() + "X" + randomBoard.getHeight());

             randomBoard.displayBoard();
             randomBoard.displayPath(); 
        }catch(IllegalArgumentException e){
             System.out.println(e.getMessage());
        }
    }
}
