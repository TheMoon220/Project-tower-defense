package bloons.board;
import bloons.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class ClassicalBoardTest {
    private Position p1;
    private Position p2;
    private Cell cell1;
    private ClassicalBoard board;


    @BeforeEach
        public void Before(){
            this.p1= new Position(1.0, 5.0);
            this.p2=new Position(1.0, 0.0);
            this.cell1= new Cell(p1) ;
            this.board= new ClassicalBoard(4,6) ; 
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
         assertNotEquals(new Cell(new Position(4, 2)), board.getCell(new Position(1.0, 0.0)));
    }
 
    @Test
    public void wrongPositionForHaveCellAtTheBoard()throws IndexOutOfBoundsException{
        assertThrows(IndexOutOfBoundsException.class,()-> this.board.getCell(new Position(-1.0, 4.0)));
    }

   @Test
   public void isItRightGenereNeighborPosition(){
      Position p3 = bloons.utils.Direction.generateNeighbor(p1);
      assertTrue(p3.getY() <= board.getHeight());
      assertTrue(p3.getX() <= board.getWidth());
      int dx = (int)(p3.getX() - p1.getX());
      int dy = (int)(p3.getY() - p1.getY());
      assertTrue(Math.abs(dx) + Math.abs(dy) == 1); 
    }

    @Test
    public void positionChooseIsRight(){
        Position p4= board.chooseValidNeighborPosition(p1);
        assertTrue(board.isValid(p4));
    }
    
    @Test 
    public void pathFoundIsRight(){
        board.calculPath();
        assertFalse(board.getPath().isEmpty());
        Position p= board.getPath().get(0);
        assertEquals(0, p.getX());
        assertTrue(p.getY()>=0);
        assertTrue(p.getY()<=6);
    }
}   
