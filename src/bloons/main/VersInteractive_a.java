package bloons.main;

import bloons.board.Board;
import bloons.board.ClassicalBoard;

public class VersInteractive_a extends LivrableInteractive{
    
    @Override
    protected Board createBoard(int width, int height, int nbBalloons){
        return new ClassicalBoard(width, height);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n=== Tower Defense Classical Board (Interactive Version) ===");
        new VersInteractive_a().run(args);
    }
    
}
