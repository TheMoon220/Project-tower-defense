
package bloons.main;

import bloons.board.*;

public class Livrable3a  extends Livrable{

 /**
     * Creates a ClassicalBoard.
     *
     * @param width width of the board
     * @param height height of the board
     * @param nbBalloons number of balloons to generate
     * @return a ClassicalBoard instance
     */
    protected Board createBoard(int width, int height, int nbBalloons){
        return new ClassicalBoard(width, height);
    }
     /**
     * Initializes the ClassicalBoard.
     * Generates balloons and displays the board and the path.
     *
     * @param board the board used in the simulation
     * @param nbBalloons number of balloons to generate
     */
    protected void initBoard(Board board, int nbBalloons){
        board.generateAllballoons(nbBalloons);
        board.displayBoard();
        board.displayPath();
    }
     /**
     * Main method of Livrable3b.
     *
     * @param args program arguments
     * @throws InterruptedException if simulation sleep is interrupted
     */
    public static void main(String[] args) throws InterruptedException{
         System.out.println("=== Livrable 3a: Classical Board ===");
        new Livrable3a().run(args);

    }
}
