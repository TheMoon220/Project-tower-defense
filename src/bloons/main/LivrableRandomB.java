package bloons.main;
import bloons.Position;
import bloons.action.*;
import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import bloons.tower.projectileTower.*;
import bloons.utils.*;
import java.util.*;

public class LivrableRandom_b extends livrable {
     @Override
    protected Board createBoard(int width, int height, int param) {
        return new RandomBoardBoard(width, height);
    }

     /**
     * Initializes the RandomBoard.
     * Generates paths and balloons.
     *
     * @param board the board used in the simulation
     * @param numPaths number of paths to generate
     */
    @Override
    protected void initBoard(Board board, int numPaths){
        RandomBoard rb = (RandomBoard) board;
        rb.generatePaths(numPaths);
        rb.displayBoard();
        //rb.generateAllballoons(numPaths);
    }

}
