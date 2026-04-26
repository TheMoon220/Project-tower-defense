package bloons.main;
import bloons.Position;
import bloons.action.*;
import bloons.balloon.Balloon;
import bloons.board.*;
import bloons.tower.*;
import bloons.tower.projectileTower.*;
import bloons.utils.*;
import java.util.*;

public class LivrableRandomB extends Livrable {
     /** the default constructor of the class livrableRandomB */
    public LivrableRandomB() { }
     @Override
    protected Board createBoard(int width, int height, int param) {
        return new RandomBoard(width, height);
    }

     /**
     * Initializes the RandomBoard.
     * Generates paths and balloons.
     *
     * @param board the board used in the simulation
     * @param numPaths number of paths to generate
     */
    @Override
    protected void initBoard(Board board, int param) {
         RandomBoard randomBoard = (RandomBoard) board;
        // Génère les chemins aléatoires (param = nombre de chemins)
        int numPaths = Math.max(1, param);
        randomBoard.generatePaths(numPaths);
         randomBoard.displayBoard(null);
        System.out.println("\n=== Placement des tours via actions ===");
        setupTowersWithActions(randomBoard);
    }
    @Override
    protected List<Tower> getTowers(Board board, int param) {
         return board.getAllTowers();
    }

    @Override
    protected void applyEvolutionForRound(Board board, int round) {
        if (round <= 5) {
            upgradeRandomTower(board);
        } else {
            downgradeRandomTower(board);
        }
    }

    @Override
    protected void displayDuringRound(Board board, long currentTime, List<Balloon> balloons) {
        System.out.println("\ntime: " + currentTime + " ms");
        ((RandomBoard) board).displayBoard(balloons);
    }

     /**
     * Place 2 tours de chaque type via BuyTowerAction
     */
    private void setupTowersWithActions(RandomBoard board) {
        List<BuyTowerAction> actions = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 2; i++) {
            Position pos1 = new Position(rand.nextInt(board.getWidth()), rand.nextInt(board.getHeight()));
            actions.add(new BuyTowerAction(
                new IceTower(400, 100, Effect.IMMEDIAT, 1500, pos1), pos1));

            Position pos2 = new Position(rand.nextInt(board.getWidth()), rand.nextInt(board.getHeight()));
            actions.add(new BuyTowerAction(
                new SlowDownTower(500, 100, Effect.IMMEDIAT, 1500, pos2), pos2));

            Position pos3 = new Position(rand.nextInt(board.getWidth()), rand.nextInt(board.getHeight()));
            actions.add(new BuyTowerAction(
                new BombTower(600, 150, Effect.DISTANCE, 1800, pos3, Projectile.BOMB), pos3));

            Position pos4 = new Position(rand.nextInt(board.getWidth()), rand.nextInt(board.getHeight()));
            actions.add(new BuyTowerAction(
                new DartMonkeyTower(200, 100, Effect.IMMEDIAT, 1000, pos4, Projectile.DART), pos4));

            Position pos5 = new Position(rand.nextInt(board.getWidth()), rand.nextInt(board.getHeight()));
            actions.add(new BuyTowerAction(
                new SniperMonkeyTower(500, Effect.IMMEDIAT, 2000, pos5, Projectile.POINTEDDART), pos5));

            Position pos6 = new Position(rand.nextInt(board.getWidth()), rand.nextInt(board.getHeight()));
            actions.add(new BuyTowerAction(
                new SuperMonkeyTower(1200, 200, Effect.IMMEDIAT, 300, pos6, Projectile.VERYSHARPDART), pos6));

            Position pos7 = new Position(rand.nextInt(board.getWidth()), rand.nextInt(board.getHeight()));
            actions.add(new BuyTowerAction(
                new TackShooterTower(350, 80, Effect.IMMEDIAT, 1200, pos7, Projectile.NEEDLE), pos7));
        }

        for (BuyTowerAction action : actions) {
            action.execute(board);
        }

        System.out.println("Tours placées: " + board.getAllTowers().size() + " tours");
    }

    private void upgradeRandomTower(Board board) {
        List<Tower> evolvable = new ArrayList<>();
        for (Tower t : board.getAllTowers()) {
            if (t.getAppliedEvolutions().size() < t.getPossibleEvolutions().size()) {
                evolvable.add(t);
            }
        }
        if (evolvable.isEmpty()) {
            System.out.println("Aucune tour ne peut évoluer !");
            return;
        }
        Tower t = evolvable.get(new Random().nextInt(evolvable.size()));
        new UpgradeTowerAction(t).execute(board);
    }

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
        Tower t = downgradable.get(new Random().nextInt(downgradable.size()));
        new DowngradeTowerAction(t).execute(board);
    }



     /**
     * Main method of LivrableRandomB
     *
     * @param args program arguments
     * @throws InterruptedException if simulation sleep is interrupted
     */
    public static void main(String[] args) throws InterruptedException{
        System.out.println("=== LivrableRandomB: Random Board ===");
        new LivrableRandomB().run(args);
    }
}
