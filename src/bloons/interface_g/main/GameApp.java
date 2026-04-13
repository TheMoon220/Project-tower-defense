package bloons.interface_g.main;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import bloons.balloon.Balloon;
import bloons.board.RandomBoard;
import bloons.interface_g.board.RandomBoardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/** is the main programm of our game */
public class GameApp extends Application{
  
    /**
     * an method for start the game
     * @param stage the stage
     */
    @Override
    public void start(Stage stage) {
       RandomBoard board = new RandomBoard(10, 10);
       board.generatePaths(5);
       board.generateAllballoons(5);
       List<Balloon> balloons = board.getAllballoons();

       RandomBoardView boardView = new RandomBoardView(board);

       // boucle de jeu
       AnimationTimer timer = new AnimationTimer() {
           @Override
           public void handle(long now) {
               // déplacer les ballons
               List<Balloon> toRemove = new ArrayList<>();
               for (Balloon b : balloons) {
                  b.moveBallon();
                  if (b.checkEndOfPath() || b.isDestroyed()) {
                      toRemove.add(b);
                  }
                }
                balloons.removeAll(toRemove);

                // redessiner
                boardView.draw(balloons);
            }
        };
        timer.start();

        BorderPane root = new BorderPane();
        root.setCenter(boardView.getCanvas());
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Bloons Tower Defense");
        stage.setScene(scene);
        stage.show();
    }

    /** the main programm */
    public static void main(String[] args){
        launch(args);
    }
}