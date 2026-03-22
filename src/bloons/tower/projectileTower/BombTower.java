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
     * put evolutions for tower
     */
    @Override
    public void putEvolutions(){
        switch (this.evolutionIndex) {
            case 1:
                double newRange = this.getRange() * 1.50;
                this.setRange(newRange);
                System.out.println("BombTower : Range evolute to 50%");
                break;
            case 2:
                double newCadance = this.getCadence() * 1.25;
                this.setCadence(newCadance);
                System.out.println("BombTower : Cadance evolute to 25%");
                break;
            case 3:
                int oldPuissance = this.getProjectil().getNiveauDegat();
                this.projectile.setNiveauDegat(oldPuissance + 1);
                System.out.println("BombTower : Puissance evolute to 1");
                break;
            case 4:
                this.setProjectile(Projectile.EXTRABOMB);
                System.out.println("BombTower : new projectile (EstraBomb)");
                break;
            default:
                System.out.println("BombTower : no possible evolution");
                return;
        }
        this.evolutionIndex++;
    }

    /**
     * remove evolutions for tower
     */
    @Override
    public void removeEvolution(){
        if(this.evolutionIndex == 1) {
            System.out.println("DartMonkeyTower : no change to remove");
            return;
        }
        this.evolutionIndex--;
        switch (this.evolutionIndex) {
            case 1:
                this.range /= 1.5;
                System.out.println("BombTower : Range decreases to 50%");
                break;
            case 2:
                this.cadence /= 1.25;
                System.out.println("BombTower : Cadance decreases to 25%");
                break;
            case 3:
                this.projectile.setNiveauDegat(this.projectile.getNiveauDegat() - 1);
                System.out.println("BombTower : Puissance decreases to 1");
                break;
            case 4:
                this.setProjectile(Projectile.BOMB);
                System.out.println("BombTower : reinit projectile (Bomb)");
                break;
            default:
                System.out.println("BombTower : no possible evolution");
                return;
        }
        
    }
}