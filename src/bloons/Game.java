package bloons;

import bloons.*;
import bloons.board.*;
import java.util.*;

/** the object Game that which centralizes everything */
public class Game {
    private Board board; // an attribute board
    private Player player; // the player who can play
    private List<Balloon> balloons; // the balloons to put on the board
    private long currentTime; // the time , allow to manipulate a huge numbers
    private int round;

    /**
     * constructor of the class Game
     * @param board the game board
     * @param player the player
     */
    public Game(Board board, Player player){
       this.board = board;
       this.player = player;
       this.balloons = new ArrayList<>();
       this.currentTime = 0;
       this.round = 0;
    }
}
