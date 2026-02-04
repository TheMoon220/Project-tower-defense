package bloons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import bloons.utils.Level;

public class BalloonTest {
    
    private Balloon bal1;
    private Balloon bal2;
    private Position pos;
    private Level l1;
    private Level l2;
    
    @BeforeEach
        public void Before(){
            pos = new Position(0, 2);
            l1 = Level.NIV1;
            l2 = Level.NIV2;
            bal1 = new Balloon(pos, l1);
            bal2 = new Balloon(pos, l2);
        }

    @Test
    public void testGetPosition (){
        assertTrue(pos.equals(bal1.getPosition()));
        assertTrue(pos.equals(bal2.getPosition()));
    }

    @Test
    public void testGetLevel(){
        assertEquals(l1, bal1.getLevel());
        assertEquals(l2, bal2.getLevel());
    }



    @Test
    public void testGetHealth(){
        assertEquals(1, bal1.getHealth());
        assertEquals(2, bal2.getHealth());
    }

    @Test
    public void testIsDestroyed(){
        bal1.setHealth();
        bal2.setHealth();
        assertEquals(0, bal1.getHealth());
        assertEquals(1, bal2.getHealth());
        assertTrue(bal1.isDestroyed());
        assertFalse(bal2.isDestroyed());
    }

    @Test
    public void testRandomSpeed() {
        double v = bal2.getSpeed();
        assertTrue(v == 1.0 || v == 2.0 || v == 3.1);
    }

    @Test
    public void testSetTrajectory() {
        List<Position> path = new ArrayList<>();
        path.add(new Position(0,0));
        path.add(new Position(1,0));

        bal1.setTrajectory(path);

        assertEquals(0, bal1.getCurrentCellIndex());
        assertEquals(0.0, bal1.getProgress());
        assertEquals(path, bal1.getPath());
    }

    @Test
    public void testSetTrajectoryException() {
        assertThrows(IllegalArgumentException.class, () -> {
            bal2.setTrajectory(new ArrayList<>());
        });
    }





}
