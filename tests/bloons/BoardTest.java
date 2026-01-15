package tests.bloons;
import bloons.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class BoardTest {
    private Position p1;
    private Position p2;
    private Cell cell1;


    @BeforeEach
        public void Before(){
            this.p1= new Position(1, 5);
            this.p2=new Position(1, 0);
            this.cell1= new Cell(p1) ;
        
        }

    
}
