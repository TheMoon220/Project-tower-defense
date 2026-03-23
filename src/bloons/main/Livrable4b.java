package bloons.main;

import bloons.board.*;

/**
 * Simulation for Livrable 4b.
 * This simulation uses a RandomBoard.
 * Paths are generated randomly.
 */
public class Livrable4b extends Livrable {

    /**
     * Creates a RandomBoard.
     *
     * @param width width of the board
     * @param height height of the board
     * @param numPaths number of paths to generate
     * @return a RandomBoard instance
     */
    @Override
    protected Board createBoard(int width, int height, int numPaths){
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
        new Livrable4b().run(args);
    }
}