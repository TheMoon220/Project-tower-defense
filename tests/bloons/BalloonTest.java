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
}
