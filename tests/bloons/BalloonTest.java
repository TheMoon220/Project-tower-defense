package bloons;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import bloons.utils.Level;

public class BalloonTest {
    
    private Balloon bal;
    private Position pos;
    @BeforeEach
        public void Before(){
            pos = new Position(0, 2);
            bal = new Balloon(pos, Level.NIV1, 2.1);
        }
}
