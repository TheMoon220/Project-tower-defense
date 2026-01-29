package bloons;

import bloons.*;
import bloons.board.*;
import bloons.utils.*;
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

    /**
     * get the board
     * @return board
     */
    public Board getBoard(){
        return this.board;
    }

    /**
     * get the player
     * @return player
     */
    public Player getPlayer(){
        return this.player;
    }

    /**
     * get the balloons
     * @return balloons 
     */
    public List<Balloon> getBalloons(){
        return this.balloons;
    }

    /**
     * get the round
     * @return round
     */
    public int getRound(){
        return this.round;
    }

    /**
     * start a new round
     */
    public void startRound(){
       this.round++;
       System.out.println("\n=== Starting Round " + this.round + " ===");

       this.displayGame(); // display the board (empty or with the path)

       System.out.println("\n===== Step 1 : player plays");
       System.out.println("No more action"); // the actions, later

       System.out.println("\n===== Step 3 : spawn balloons");
       this.spawnBalloons();

       System.out.println("\n===== Step 3 : balloons run");
    }
}
