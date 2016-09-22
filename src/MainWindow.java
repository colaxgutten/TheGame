import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainWindow extends Application {
	private Stage stage;
	private GameLoop loop;
	
	@Override
	public void start(Stage stage) {
		this.stage = stage;
		loop = new GameLoop();
		
		StartScreen ss = new StartScreen();
		
		ss.init(stage,loop);
	}
}