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
    protected void initBoard(Board board, int param) {
         RandomBoard randomBoard = (RandomBoard) board;
        // Génère les chemins aléatoires (param = nombre de chemins)
        int numPaths = Math.max(1, param);
        randomBoard.generatePaths(numPaths);
         randomBoard.displayBoard(null);
        System.out.println("\n=== Placement des tours via actions ===");
        setupTowersWithActions(randomBoard);
    }
    @Override
    protected List<Tower> getTowers(Board board, int param) {
         return board.getAllTowers();
    }

    @Override
    protected void applyEvolutionForRound(Board board, int round) {
        if (round <= 5) {
            upgradeRandomTower(board);
        } else {
            downgradeRandomTower(board);
        }
    }

    @Override
    protected void displayDuringRound(Board board, long currentTime, List<Balloon> balloons) {
        System.out.println("\ntime: " + currentTime + " ms");
        ((RandomBoard) board).displayBoard(balloons);
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
