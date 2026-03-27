package bloons.board;
import bloons.*;
import bloons.balloon.Balloon;
import bloons.utils.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.*;
 public class RandomBoardTest{
    private Position p1;
    private Position p2;
    private Cell cell1;
    private RandomBoard board;


    @BeforeEach
        public void Before(){
            this.p1= new Position(1, 5);
            this.p2=new Position(1, 0);
            this.cell1= new Cell(p1) ;
            this.board= new RandomBoard(4,6) ;

         }

    @Test
    public void wrongdimensionBoardShouldException()throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class,()-> new ClassicalBoard(-1, 7) );

    }

    @Test
    public void dimensionWidthHeightIsCorrect(){
        assertEquals(4, board.getWidth());
        assertEquals(6, board.getHeight());
        assertNotEquals(5, board.getHeight());

    }

    @Test

    public void  cellAtPositionPAtTheBoard(){
         assertNotEquals(cell1, board.getCell(p2));
         assertNotEquals(new Cell(new Position(4, 2)), board.getCell(new Position(1, 0)));
    }
 
    @Test
    public void wrongPositionForHaveCellAtTheBoard()throws IndexOutOfBoundsException{
        assertThrows(IndexOutOfBoundsException.class,()-> this.board.getCell(new Position(-1, 4)));
    }

    @Test
    public void generatePathsCreatesCorrectNumberOfPaths(){
        board.generatePaths(3);
        assertEquals(3, board.getAllPaths().size());
    }

    @Test
    public void generatePathsThrowsExceptionWhenTooManyPaths(){
        assertThrows(IllegalArgumentException.class, () -> board.generatePaths(10)); // 4+6=10
    }

    @Test
    public void generatePathsNoOverlap(){
       board.generatePaths(3);
       List<List<Position>> paths = board.getAllPaths();
       for(int i = 0; i < paths.size(); i++){
           for(int j = i + 1; j < paths.size(); j++){
              assertNotEquals(new HashSet<>(paths.get(i)), new HashSet<>(paths.get(j)));
            }
        }
    }

    @Test
    public void getPathAtValidIndex(){
       board.generatePaths(3);
       assertNotNull(board.getPathAt(0));
    }

    @Test
    public void getPathAtInvalidIndexThrowsException(){
       board.generatePaths(3);
       assertThrows(IllegalArgumentException.class, () -> board.getPathAt(5));
    }

    @Test
    public void createBalloonForPathIsCorrect(){
      board.generatePaths(2);
      Balloon b = board.createBalloonForPath(0, Level.NIV1);
      assertNotNull(b);
      assertNotNull(b.getPath());
    }
}
