package bloons;

import bloons.board.*;
import bloons.utils.*;
import java.util.*;

/** the object Livrable2b, the main programm */
public class Livrable2b {
    public static void main(String[] args){
        // check arguments
        if(args.length != 3){
            System.out.println("for use it: java -classpath classes bloons.Livrable2b width height numPath");
            return;
        }

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int numPath = Integer.parseInt(args[2]);
    }
}
