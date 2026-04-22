package bloons.main;

import bloons.board.Board;
import bloons.board.ClassicalBoard;

public class Livrable6 extends Livrable {
    
    @Override
    protected Board createBoard(int width, int height, int param) {
        return new ClassicalBoard(width, height);
    }
}
