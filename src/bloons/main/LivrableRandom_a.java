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
        setupTowersWithActions((ClassicalBoard) board);
    }

    @Override
    protected List<Tower> getTowers(Board board, int param) {
        // Towers already placed by setupTowersWithActions()
        return board.getAllTowers();
    }

    @Override
    protected void applyEvolutionForRound(Board board, int round) {
        System.out.println("\n--- Round " + round + " ---");
        Board.PLAYER.toString();
        
        ListChooser<String> actionChooser = new RandomListChooser<>();
        List<String> possibleActions = Arrays.asList("Buy", "Upgrade", "Downgrade", "Start");

        boolean startRound = false;
        int actionCount = 0;

        // Le bot a le droit à un maximum de 5 actions par tour pour ne pas boucler à l'infini
        while (!startRound && actionCount < 5 && Board.PLAYER.getHealth() > 0) {
            String choice = actionChooser.choose("Action :", possibleActions);
            
            if (choice == null || choice.equals("Start")) {
                startRound = true;
                System.out.println("Balloon launch !");
            } else if (choice.equals("Buy")) {
                buyRandomTower(board);
            } else if (choice.equals("Upgrade")) {
                upgradeRandomTower(board);
            } else if (choice.equals("Downgrade")) {
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

    /**
     * Place 2 towers of each type using BuyTowerAction
     */
    private void setupTowersWithActions(ClassicalBoard board) {
        List<BuyTowerAction> actions = new ArrayList<>();
        
        for (int i = 0; i < 2; i++) {
            // IceTower (cannot evolve)
            Position pos1 = board.getValidTowerPosition();
            actions.add(new BuyTowerAction(
                new IceTower(400, 100, Effect.IMMEDIAT, 1500, pos1), pos1));
            
            // SlowDownTower (cannot evolve)
            Position pos2 = board.getValidTowerPosition();
            actions.add(new BuyTowerAction(
                new SlowDownTower(500, 100, Effect.IMMEDIAT, 1500, pos2), pos2));
            
            // BombTower
            Position pos3 = board.getValidTowerPosition();
            actions.add(new BuyTowerAction(
                new BombTower(600, 150, Effect.DISTANCE, 1800, pos3, Projectile.BOMB), pos3));
            
            // DartMonkeyTower
            Position pos4 = board.getValidTowerPosition();
            actions.add(new BuyTowerAction(
                new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos4, Projectile.DART), pos4));
            
            // SniperMonkeyTower
            Position pos5 = board.getValidTowerPosition();
            actions.add(new BuyTowerAction(
                new SniperMonkeyTower(500, Effect.IMMEDIAT, 2000, pos5, Projectile.POINTEDDART), pos5));
            
            // SuperMonkeyTower
            Position pos6 = board.getValidTowerPosition();
            actions.add(new BuyTowerAction(
                new SuperMonkeyTower(1200, 200, Effect.IMMEDIAT, 300, pos6, Projectile.VERYSHARPDART), pos6));
            
            // TackShooterTower
            Position pos7 = board.getValidTowerPosition();
            actions.add(new BuyTowerAction(
                new TackShooterTower(350, 80, Effect.IMMEDIAT, 1200, pos7, Projectile.NEEDLE), pos7));
        }
        
        // Execute all actions
        for (BuyTowerAction action : actions) {
            action.execute(board);
        }
        
        System.out.println("\nTowers placed: " + board.getAllTowers().size() + " towers");
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