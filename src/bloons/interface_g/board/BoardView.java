package interface_g.bloons.board;

import bloons.balloon.Balloon;
import bloons.board.Board;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.List;

/** the object BoardView that represent the land */
public abstract class BoardView {
    /** the canvas for the land */
    protected Canvas canvas;
    /** the context for the graphic */
    protected GraphicsContext gc;
    /** the type of board */
    protected Board board;
    /** the size of a cell */
    public static final int CELL_SIZE = 50;

    /**
     * the constructor of the class
     * @param board the type of board
     */
    public BoardView(Board board){
        this.board = board;
        this.canvas = new Canvas(board.getWidth() * CELL_SIZE, board.getHeight() * CELL_SIZE);
        this.gc = canvas.getGraphicsContext2D();
    }

    /**
     * draw the grid
     */
    protected void drawGrid(){
        for (int x = 0; x < this.board.getWidth(); x++) {
            for(int y = 0; y < this.board.getHeight(); y++){
                this.gc.setFill(Color.GREEN);
                this.gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                this.gc.setStroke(Color.DARKGREEN);
                this.gc.strokeRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    /** an method for draw the path */
    protected abstract void drawPath();

    /**
     * an method for draw the balloons
     * @param balloons a list of balloons
     */
    public void drawBalloons(List<Balloon> balloons){
        this.gc.setFill(Color.RED);
        for(Balloon b: balloons){
            int balX = (int) Math.round(b.getPosition().getX());
            int balY = (int) Math.round(b.getPosition().getY());
            this.gc.fillOval(
                balX * CELL_SIZE + 10,
                balY * CELL_SIZE + 10,
                CELL_SIZE - 20,
                CELL_SIZE - 20
            );
        }
    }
}
