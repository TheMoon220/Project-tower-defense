package bloons;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PlayerTest {

    private Player p1;
    private Player p2;
    
    @BeforeEach
        public void Before(){
            this.p1 = new Player(40, 600);
            this.p2 = new Player(25, 250);
        } 
    
    @Test
    public void testGetHealth() {
        // Test if the player's health is correctly returned
        assertEquals(40, p1.getHealth());
        assertEquals(25, p2.getHealth());
    }
    

}
