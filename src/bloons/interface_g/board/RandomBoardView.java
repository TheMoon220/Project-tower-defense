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

    /**
     * draw the path
     */
    @Override
    protected void drawPath(){
        this.gc.setFill(Color.GRAY);
        for(List<Position> path: this.randomBoard.getAllPaths()){
            for(Position p: path){
              this.gc.fillRect( 
                  (int) p.getX() * CELL_SIZE,
                  (int) p.getY() * CELL_SIZE,
                  CELL_SIZE,
                  CELL_SIZE
               );
                this.gc.setStroke(Color.DARKGRAY);
                this.gc.strokeRect(
                    (int) p.getX() * CELL_SIZE,
                    (int) p.getY() * CELL_SIZE,
                    CELL_SIZE,
                    CELL_SIZE
                );
            }
        }
    }
}
