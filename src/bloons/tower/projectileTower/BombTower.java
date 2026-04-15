package bloons.tower.projectileTower;

import bloons.Position;
import bloons.balloon.*;
import bloons.utils.*;
import java.util.*;

/** the object Bomb tower, the tower that sends bombs */
public class BombTower extends ProjectileTower {
    
     /** 
     * the constructor of the class Tower
     * @param cost the tower's price
     * @param range the tower's scope
     * @param effect the tower's impact
     * @param cadence the tower's cadence
     * @param position the tower's position
     * @param projectile the tower's projectile
     */
    public BombTower(double cost ,double range ,Effect effect ,double cadence,Position position, Projectile projectile){
       super(cost, range, effect, cadence,position, projectile);
       this.possibleEvolutions.put(Evolution.POWER, 200);
       this.possibleEvolutions.put(Evolution.RANGE, 250);
       this.possibleEvolutions.put(Evolution.CADANCE, 300);
       this.possibleEvolutions.put(Evolution.PROJECTILE, 400);
    }

    /**  
     * attack the most advanced balloon in range and a random balloon nearby
     * @param balloon the balloon 
     * @param currTime the current TIme
     * @exception InterruptedException when current time is not valide
    */ 
    @Override
    public void attackBallon(Balloon balloon, long currTime) throws InterruptedException{
        if(canAttack(currTime) && Inrange(balloon)){
            super.attackBallon(balloon,currTime);

            this.getAllBalloonsInRange();
            this.balloonsInRange.remove(balloon);
            if(!this.balloonsInRange.isEmpty()){
               int size =this.balloonsInRange.size();
               Balloon bal = this.balloonsInRange.get(new Random().nextInt(size));
               int newHealth = bal.getHealth() - this.projectile.getNiveauDegat();
               bal.setHealth(newHealth);

               if (newHealth <= 0) 
                  balloons.remove(bal);
            }
        }
    }

    /**
     * apply evolutions for tower
     */
    @Override
    public void applyEvolution(Evolution evo){
        switch (evo) {
            case POWER:
                this.projectile.setNiveauDegat(this.projectile.getNiveauDegat() + 1);
                System.out.println("BombTower : Power evolute to 1");
                break;
            case RANGE: 
                this.setRange(this.getRange() * 1.50);
                System.out.println("BombTower : Range evolute to 50%");
                break;
            case CADANCE: 
                this.setCadence(this.getCadence() * 1.25);
                System.out.println("BombTower : Cadence evolute to 25%");
                break;
            case PROJECTILE:
                this.setProjectile(Projectile.EXTRABOMB);
                System.out.println("BombTower : new projectile (ExtraBomb)");
                break;
            default:
                System.out.println("BombTower : no possible evolution");
                return;
        }
    }

    /**
     * remove evolutions for tower
     */
    @Override
    public void removeEvolutionEffect(Evolution evo){
          
        switch (evo) {
            case RANGE:
                this.range /= 1.5;
                System.out.println("BombTower : Range decreases to 50%");
                break;
            case CADANCE:
                this.cadence /= 1.25;
                System.out.println("BombTower : Cadance decreases to 25%");
                break;
            case POWER:
                this.projectile.setNiveauDegat(this.projectile.getNiveauDegat() - 1);
                System.out.println("BombTower : Power decreases to 1");
                break;
            case PROJECTILE:
                this.setProjectile(Projectile.BOMB);
                System.out.println("BombTower : reinitialise projectile (Bomb)");
                break;
        }
    }
}