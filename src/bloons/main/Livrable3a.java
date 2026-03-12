
package bloons.main;

import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import java.util.ArrayList;
import java.util.List;


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

}
