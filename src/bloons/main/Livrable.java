package bloons.main;
import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import java.util.*;

public  abstract class Livrable {
    /**
     * Create the appropriate board type.
     * @param width the width of the board 
     * @param height the height of the board 
     * @param param  
     * @return
     */
    protected abstract Board createBoard(int width, int height, int param);

    protected abstract void initBoard(Board board, int param);
    public  void run(String[] args) throws InterruptedException{
        // check arguments
        if(args.length != 3){
            System.out.println("for use it: java -classpath classes bloons.Livrable2b width height numPath");
            return;
        }
        

    }}