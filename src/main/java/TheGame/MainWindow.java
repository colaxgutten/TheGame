package TheGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainWindow extends Application {
	private Stage stage;
	private GameLoop loop;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		
		Settings settings = Settings.load("s.txt");
		loop = new GameLoop();
		
		StartScreen ss = new StartScreen();
		
		ss.init(stage,loop, settings);
	}
}