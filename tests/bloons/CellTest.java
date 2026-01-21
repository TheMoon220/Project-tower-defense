package tests.bloons;
import bloons.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
public class CellTest {
    private Position p1;
    private Position p2;
    private Cell cell1;


    @BeforeEach
        public void Before(){
            this.p1= new Position(1, 5);
            this.p2=new Position(1, 0);
            this.cell1= new Cell(p1) ;
        
        }
    @Test
    public void correctcellPosition(){
        assertEquals(p1, cell1.getPos());
        assertNotEquals(p2, cell1.getPos());
    }

    
}
