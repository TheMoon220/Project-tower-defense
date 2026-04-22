package bloons.main;

import bloons.board.Board;
import bloons.board.ClassicalBoard;

public class Livrable6 extends Livrable {
    
    @Override
    protected Board createBoard(int width, int height, int param) {
        return new ClassicalBoard(width, height);
    }

    @Override
    protected void initBoard(Board board, int param) {
        board.displayBoard();
        board.displayPath();
        System.out.println("Player money : " + Board.PLAYER.getCredit());
        System.out.println("Player lives : " + Board.PLAYER.getHealth());
    }
}
