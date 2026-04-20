package bloons.action;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ActionTest {
    
    @Test 
    public void testActionExecuteReturnsTrue(){
        Action action = new Action(){
            @Override
            public boolean execute(Board board){
                return true;
            }

            @Override
            public String getDescription(){
                return "Test Action";
            }

            @Override
            public int getCost(){
                return 0;
            }
        };

        assertTrue(action.execute(null));
    }
}
