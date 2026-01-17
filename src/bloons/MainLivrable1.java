package bloons;

import bloons.board.*;

public class MainLivrable1 {
    public static void main(String[] args) {
        try{
           Board randomBoard = new RandomBoard(8,8);
           Board classicalBoard = new ClassicalBoard(8,8);
           System.out.println("display random board: " + randomBoard.getWidth() + "X" + randomBoard.getHeight());
           randomBoard.displayBoard();
           randomBoard.displayPath();

           System.out.println("display classical board: " + classicalBoard.getWidth() + "X" + classicalBoard.getHeight());
           classicalBoard.displayBoard();
           classicalBoard.displayPath();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }   
    }
}
