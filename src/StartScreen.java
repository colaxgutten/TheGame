import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartScreen {
	String saveName;
	Stage stage;
	
	public void init(Stage stage, GameLoop loop) {
		this.stage = stage;
		
		Pane pane = new Pane();		
		Button b = new Button();
		b.setOnMouseClicked(e -> {
			startGame(saveName, loop);
		});
	}
	
	public void startGame(String saveName, GameLoop loop) {
		Game game;
		
		if(saveName.equals("")) {
			game = GameLoader.newGame();
		} else {
			game = GameLoader.load(saveName);
		}
		
		loop.start(game);
	}
}
