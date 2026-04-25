package bloons.main;
import bloons.Position;
import bloons.action.*;
import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import bloons.tower.projectileTower.*;
import bloons.utils.*;
import java.util.*;

public class LivrableRandomB extends Livrable {
     /** the default constructor of the class livrableRandomB */
    public LivrableRandomB() { }
     @Override
    protected Board createBoard(int width, int height, int param) {
        return new RandomBoard(width, height);
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
     /**
     * Main method of Livrable4b.
     *
     * @param args program arguments
     * @throws InterruptedException if simulation sleep is interrupted
     */
    public static void main(String[] args) throws InterruptedException{
        System.out.println("=== Livrable 4b: Random Board ===");
        new LivrableRandomB().run(args);
    }
}
