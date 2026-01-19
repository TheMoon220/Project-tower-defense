package bloons.board;

import bloons.*;

public class RandomBoard extends Board {

    /**
     * Builds a board wiht sizes width and height
     * @param width the width of the board
     * @param height the height of the board
     */
    public RandomBoard(int width, int height){
        super(width, height);
        this.calculPath();
    }

    /** a method for calculate the path (horizontal or vertical) in the board*/
    @Override
    public void calculPath(){
       this.path.clear(); 

       int x = 0;
       int y = (int)(Math.random() * this.height);

       this.path.add(new Position(x, y));

       while(x < this.width - 1){
          int move = (int)(Math.random() * 3);

          if(move == 0 && x + 1 < this.height) 
            x++; // avancer
          else if(move == 1 && y > 0)
            y--; // monter
          else if(move ==2 && y < this.height - 1)
            y++; // descendre

          Position pos = new Position(x,y);
          if(!this.path.contains(pos))
            this.path.add(pos);
       }
    }
}
