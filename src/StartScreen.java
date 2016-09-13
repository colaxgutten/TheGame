import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartScreen {
	String saveName;
	Stage stage;
	
	public void init(Stage stage) {
		this.stage = stage;
		
		Pane pane = new Pane();		
		Button b = new Button();
		b.setOnMouseClicked(e -> {
			startGame(saveName);
		});
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
