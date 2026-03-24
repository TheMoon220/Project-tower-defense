
package bloons.main;

import bloons.board.*;

/** the object Livrable4a that inherite Livrable */
public class Livrable4a  extends Livrable{

    /** the default constructor of the class livrable */
    public Livrable4a() { }

    /**
     * Creates a ClassicalBoard.
     *
     * @param width width of the board
     * @param height height of the board
     * @param nbBalloons number of balloons to generate
     * @return a ClassicalBoard instance
     */
    @Override
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
    @Override
    protected void initBoard(Board board, int nbBalloons){
       // board.generateAllballoons(nbBalloons);
        board.displayBoard();
        board.displayPath();
    }
     /**
     * Main method of Livrable4b.
     * @param args program arguments
     * @throws InterruptedException if simulation sleep is interrupted
     */
    public static void main(String[] args) throws InterruptedException{
        System.out.println("=== Livrable 4a: Classical Board ===");
        new Livrable4a().run(args);
    }
}
