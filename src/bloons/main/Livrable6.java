package bloons.main;

import java.io.IOException;

import bloons.action.BuyTowerAction;
import bloons.board.Board;
import bloons.board.ClassicalBoard;
import bloons.tower.IceTower;
import bloons.tower.SlowDownTower;
import bloons.tower.Tower;
import bloons.tower.projectileTower.BombTower;
import bloons.tower.projectileTower.DartMonkeyTower;
import bloons.tower.projectileTower.SniperMonkeyTower;
import bloons.tower.projectileTower.SuperMonkeyTower;
import bloons.tower.projectileTower.TackShooterTower;
import bloons.utils.Effect;
import bloons.utils.Input;
import bloons.utils.Projectile;

public class Livrable6 extends Livrable {
    
    @Override
    protected Board createBoard(int width, int height, int param) {
        return new ClassicalBoard(width, height);
    }

    @Override
    protected void initBoard(Board board, int param) {
        board.displayBoard();
        board.displayPath();
        System.out.println("Player money : " + Board.PLAYER.getCredit());
        System.out.println("Player lives : " + Board.PLAYER.getHealth());
    }

    private void buyTower(Board board) {
        System.out.println("\n--- ALL TOWERS ---");
        System.out.println("1. DartMonkey Tower (cost : 200)");
        System.out.println("2. TackShooter Tower (cost : 350)");
        System.out.println("3. IceTower (cost : 400)");
        System.out.println("4. Sniper Monkey Tower (cost : 500)");
        System.out.println("5. SlowDown Tower (cost : 500)");
        System.out.println("6. Bomb Tower (cost : 600)");
        System.out.println("7. SuperMonkey Tower (cost : 1200)");
        System.out.println("8. Cancel");
        System.out.print("Choice : ");

        try {
            int choice = Input.readInt();
            if (choice == 8) return;
            if (choice < 1 || choice > 7) return;

            System.out.print("X : ");
            int x = Input.readInt();
            System.out.print("Y : ");
            int y = Input.readInt();
            Position pos = new Position(x, y);

            Tower t = null;
            switch (choice) {
                case 1:
                    t = new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos, Projectile.DART); 
                    break;
                case 2:
                    t = new TackShooterTower(350, 80, Effect.IMMEDIAT, 1200, pos, Projectile.NEEDLE); 
                    break;
                case 3:
                    t = new IceTower(400, 100, Effect.IMMEDIAT, 1500, pos); 
                    break;
                case 4:
                    t = new SniperMonkeyTower(500, Effect.IMMEDIAT, 2000, pos, Projectile.POINTEDDART); 
                    break;
                case 5:
                    t = new SlowDownTower(500, 100, Effect.IMMEDIAT, 1500, pos); 
                    break;
                case 6:
                    t = new BombTower(600, 150, Effect.DISTANCE, 1800, pos, Projectile.BOMB); 
                    break;
                case 7:
                    t = new SuperMonkeyTower(1200, 200, Effect.IMMEDIAT, 300, pos, Projectile.VERYSHARPDART); 
                    break;
            }

            if (t != null){
                new BuyTowerAction(t, pos).execute(board);
            } 
        } catch (IOException e) { System.out.println("Wrong input !!"); }
    }
}
