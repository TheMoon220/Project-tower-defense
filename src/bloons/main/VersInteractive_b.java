package bloons.main;

import bloons.board.Board;
import bloons.board.RandomBoard;

public class VersInteractive_b extends LivrableInteractive{
    
    @Override
    protected Board createBoard(int width, int height, int numPaths){
        return new RandomBoard(width, height);
    }
}
