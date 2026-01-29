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

    /**
     * spawn balloons for the current round
     */
    private void spawnBalloons(){
        int count = 3 + (this.round -1) * 3; // Round 1: 3, Round 2: 6, etc...
        if(this.board instanceof ClassicalBoard){
            for(int i = 0; i < count; i++){
                double speed = 1.0 + i + (this.round * 0.1);
                Level level = getLevelForRound(round);
                
                Balloon balloon = new Balloon(level, this.board);
                balloon.setSpeed(speed);
                this.balloons.add(balloon);

                System.out.println("Bloon " + i + "at (" + 
                                   (int)balloon.getPosition().getX() + ", " +
                                   (int)balloon.getPosition().getY() + ") speed: " + 
                                    balloon.getSpeed() + " health: " + balloon.getHealth());
            }
        }else if(board instanceof RandomBoard){
            RandomBoard rb = (RandomBoard) board;
            for(int i = 0; i < count; i++){
                double speed = 1.0 + i + (this.round * 0.1);
                Level level = getLevelForRound(this.round);

                Balloon balloon = rb.spawnBalloon(level);
                balloon.setSpeed(speed);
                this.balloons.add(balloon);

                System.out.println("Bloon " + i + " at (" + (int)balloon.getPosition().getX() +
                                   ", " + (int)balloon.getPosition().getY() + ") speed: " + 
                                   balloon.getSpeed() + " health: " + balloon.getHealth());
            }
        }
        System.out.println("Spawned " + count + " bloons.");
    }

    /**
     * get balloon level based on round number
     */
    private Level getLevelForRound(int round){
        if(round == 1)
            return Level.NIV2;
        else if(round <= 3)
            return Level.NIV2;
        else 
            return Level.NIV4;
    }
}
