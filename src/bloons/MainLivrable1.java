package bloons;

import bloons.board.RandomBoard;

public class MainLivrable1 {
    public static void main(String[] args) {
        try{
           Board randomBoard = new RandomBoard(8,8);
           System.out.println("display board: " + randomBoard.getWidth() + "X" + randomBoard.getHeight());
           randomBoard.displayBoard();
           randomBoard.displayPath();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }   
    }
}
