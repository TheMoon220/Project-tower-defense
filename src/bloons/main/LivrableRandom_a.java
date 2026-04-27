package bloons.main;

import bloons.Position;
import bloons.action.*;
import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import bloons.tower.projectileTower.*;
import bloons.utils.*;
import java.util.*;

/**
 * Livrable 5: Classical Board with Actions for tower placement and evolutions
 */
public class LivrableRandom_a extends Livrable {

    @Override
    protected Board createBoard(int width, int height, int param) {
        return new ClassicalBoard(width, height);
    }

    @Override
    protected void initBoard(Board board, int param) {
        board.displayBoard();
        board.displayPath();
        System.out.println("\n=== Tower placement via actions ===");
        
    }

    @Override
    protected List<Tower> getTowers(Board board, int param) {
        // Towers already placed by setupTowersWithActions()
        return board.getAllTowers();
    }

    @Override
    protected void applyEvolutionForRound(Board board, int round) {
        board.displayBoard();
        System.out.println(board.PLAYER.toString());
        
        ListChooser<String> actionChooser = new RandomListChooser<>();
        List<String> possibleActions = Arrays.asList("Buy", "Upgrade", "Downgrade", "Start");

        boolean startRound = false;
        int actionCount = 0;

        // Le bot a le droit à un maximum de 5 actions par tour pour ne pas boucler à l'infini
        while (!startRound && actionCount < 5 && Board.PLAYER.getHealth() > 0) {
            System.out.println();
            String choice = actionChooser.choose("Action :", possibleActions);
            
            if (choice == null || choice.equals("Start")) {
                startRound = true;
                System.out.println("\nChoose : Start\n");
                System.out.println("Balloon launch ....");
            } else if (choice.equals("Buy")) {
                System.out.println("\nChoose : Buy\n");
                buyRandomTower(board);
            } else if (choice.equals("Upgrade")) {
                System.out.println("\nChoose : Upgrade\n");
                upgradeRandomTower(board);
            } else if (choice.equals("Downgrade")) {
                System.out.println("\nChoose : Downgrade\n");
                downgradeRandomTower(board);
            }
            actionCount++;
        }
    }

    @Override
    protected void displayDuringRound(Board board, long currentTime, List<Balloon> balloons) {
        // Simplified display: no balloon positions at each time step
        System.out.println("\ntime: " + currentTime + " ms");
        // Board display is omitted as required by livrable 5
    }


    private void buyRandomTower(Board board) {
        List<String> towerNames = Arrays.asList(
            "DartMonkey", "TackShooter", "IceTower", "SniperMonkey", 
            "SlowDown", "BombTower", "SuperMonkey"
        );
        ListChooser<String> chooser = new RandomListChooser<>();
        String choice = chooser.choose("All towers:", towerNames);
        if (choice == null) return;

        // Génère une position valide
        Random rand = new Random();
        Position pos;
        do {
            pos = new Position(rand.nextInt(board.getWidth()), rand.nextInt(board.getHeight()));
        } while (board.isPositionOccupiedByTower(pos) || (board.getPath() != null && board.getPath().contains(pos)));

        Tower t = null;
        switch (choice) {
            case "DartMonkey": t = new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos, Projectile.DART); break;
            case "TackShooter": t = new TackShooterTower(350, 80, Effect.IMMEDIAT, 1200, pos, Projectile.NEEDLE); break;
            case "IceTower": t = new IceTower(400, 100, Effect.IMMEDIAT, 1500, pos); break;
            case "SniperMonkey": t = new SniperMonkeyTower(500, Effect.IMMEDIAT, 2000, pos, Projectile.POINTEDDART); break;
            case "SlowDown": t = new SlowDownTower(500, 100, Effect.IMMEDIAT, 1500, pos); break;
            case "BombTower": t = new BombTower(600, 150, Effect.DISTANCE, 1800, pos, Projectile.BOMB); break;
            case "SuperMonkey": t = new SuperMonkeyTower(1200, 200, Effect.IMMEDIAT, 300, pos, Projectile.VERYSHARPDART); break;
        }

        if (t != null){
            new BuyTowerAction(t, pos).execute(board);
        } 
    }

    /**
     * Choose a random tower that can still evolve
     */
    private void upgradeRandomTower(Board board) {
        List<Tower> evolvable = new ArrayList<>();
        for (Tower t : board.getAllTowers()) {
            if (t.getAppliedEvolutions().size() < t.getPossibleEvolutions().size()) {
                evolvable.add(t);
            }
        }
        if (evolvable.isEmpty()) {
            System.out.println("No tower can evolve!");
            return;
        }
        Tower t = new RandomListChooser<Tower>().choose("Upgrading tower :", evolvable);
        if (t != null){
            new UpgradeTowerAction(t).execute(board);
        }
    }

    /**
     * Choose a random tower that has evolutions to remove
     */
    private void downgradeRandomTower(Board board) {
        List<Tower> downgradable = new ArrayList<>();
        for (Tower t : board.getAllTowers()) {
            if (!t.getAppliedEvolutions().isEmpty()) {
                downgradable.add(t);
            }
        }
        if (downgradable.isEmpty()) {
            System.out.println("No tower has evolutions to remove!");
            return;
        }
        Tower t = new RandomListChooser<Tower>().choose("Downgrading tower :", downgradable);
        if (t != null) new DowngradeTowerAction(t).execute(board);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n=== Tower Defense Classical Board (Ramdom Version) ===");
        new LivrableRandom_a().run(args);
    }
}