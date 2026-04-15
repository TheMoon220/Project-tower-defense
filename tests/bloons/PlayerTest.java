package bloons;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PlayerTest {

    private Player p1;
    private Player p2;
    
    @BeforeEach
        public void Before(){
            this.p1 = new Player();
            this.p2 = new Player();
        } 
    
    @Test
    public void testGetHealth() {
        assertEquals(20, p1.getHealth());
        assertEquals(20, p2.getHealth());
    }
    
    @Test
    public void testGetCredit() {
        assertEquals(600, p1.getCredit());
        assertEquals(250, p2.getCredit());
    }

    @Test
    public void testSetHealth() {
        p1.loseLife();
        assertEquals(39, p1.getHealth()); // le niveau de vie decremente de 1
    }
    @Test
    public void testSetCredit(){
        // p1.setCredit();
        // assertEquals(610, p1.getCredit());
    } 

}
