package tests.bloons;
import bloons.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PositionTest {
    private Position p1;
    private Position p2;
    private Position p3;
    private Position p4;


    @BeforeEach
        public void Before(){
            this.p1= new Position(1, 5);
            this.p2=new Position(1, 0);
            this.p3= new Position(3, 2);
            this.p4= new Position(1, 5);

        }

    @Test
    public void positionXyIsCorrect(){
        assertEquals(1,p1.getX());
        assertEquals(5, p1.getY());
        assertNotEquals(4, p4.getX());
        assertNotEquals(8, p2.getY());

    }

    @Test
    public void twoPositonIsItEquals(){
         assertFalse(p1.equals(p2));
         assertTrue(p1.equals(p4));
    }
}
