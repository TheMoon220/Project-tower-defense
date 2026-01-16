package tests.bloons.board;
import bloons.board.*;
import bloons.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
 public class RandomBoardTest{
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

    }


