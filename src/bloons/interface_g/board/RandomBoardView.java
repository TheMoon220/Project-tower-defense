package interface_g.bloons.board;

import bloons.board.RandomBoard;
import bloons.Position;
import javafx.scene.paint.Color;
import java.util.List;

/** the object of the class BoardView */
public class RandomBoardView extends BoardView{
    /** the board */
    private RandomBoard randomBoard;

    /**
     * the constructor of the class
     */
    public RandomBoardView(RandomBoard board){
        super(board);
        this.randomBoard = board;
    }
}
