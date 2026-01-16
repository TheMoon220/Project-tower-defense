package tests.bloons.board;
import bloons.board.*;
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
            this.p1= new Position(1, 5);
            this.p2=new Position(1, 0);
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
         assertNotEquals(new Cell(new Position(4, 2)), board.getCell(new Position(1, 0)));
    }
 
    @Test
    public void wrongPositionForHaveCellAtTheBoard()throws IndexOutOfBoundsException{
        assertThrows(IndexOutOfBoundsException.class,()-> this.board.getCell(new Position(-1, 4)));
    }
}
