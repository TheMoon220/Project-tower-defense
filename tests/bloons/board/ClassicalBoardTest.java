package tests.bloons.board;
import bloons.board.*;
import bloons.*;
import bloons.utils.*;
import static org.junit.Assert.assertEquals;
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

    @Test 

    public void isItpositionValid(){
        assertTrue(board.isValid(p1));
        assertFalse(board.isValid(new Position(0, 9)));
        assertFalse(board.isValid(new Position(1,-5)));
        assertFalse(board.getPath().contains(p1));
    }
    
    @Test
    public void  isItRightGenereNeighborPosition(){
        Position p3= Direction.generateNeighbor(p1);
        assertTrue(p3.getY()<=board.getHeight());
        assertTrue(p3.getX()<=board.getWidth());
        int dx= (p3.getX()-p1.getX());
        int dy= (p3.getY()-p1.getY());
        assertTrue(dx+dy==1); // pour verifier si la position generer est une position voisine (right,top,down) 

      
    }

    @Test
    public void positionChooseIsRight(){
        Position p4= board.chooseValidNeighborPosition(p1);
        assertTrue(board.isValid(p4));
    }
}
