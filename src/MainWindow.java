import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainWindow extends Application {
	private Stage stage;
	
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		
		StartScreen ss = new StartScreen();
		
		ss.init(stage);
	}
	
	public void startGame(String saveName) {
		Game game;
		
		if(saveName.equals("")) {
			game = GameLoader.newGame();
		} else {
			game = GameLoader.load(saveName);
		}
		
		new GameLoop(stage, game).start();
	}
}