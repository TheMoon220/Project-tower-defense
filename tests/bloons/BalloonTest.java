package bloons;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import bloons.utils.Level;

public class BalloonTest {
    
    private Balloon bal;
    private Position pos;
    private Level l;

    @BeforeEach
        public void Before(){
            pos = new Position(0, 2);
            l = Level.NIV1;
            bal = new Balloon(pos, l, 2.1);
        }

    @Test
    public void testGetPosition (){
        assertTrue(pos.equals(bal.getPosition()));
    }

    @Test
    public void testGetLevel(){
        assertEquals(l, bal.getLevel());
    }

    @Test
    public void testGetSpeed(){
        assertEquals(2.1, bal.getSpeed());
    }

    @Test
    public void testGetResistance(){
        assertEquals(1, bal.getHealth());
    }


}
