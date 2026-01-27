package bloons;
import bloons.utils.*;
public class Balloon {
    private   Position position;
    private  Level level ;
    private  int health;
    private double speed ;

    public Balloon(Position position, Level level){
        this.position = position;
        this.level = level;
        this.speed= 
        this.health= 

    }  

    public Level getLevel(){
        return this.level;
    }

    public Position getPosition(){
        return this.position;
    }
    public double getSpeed(){
        return this.speed;
    }
    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void moovBalloon(){
        
    }

}