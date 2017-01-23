package TheGame;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartScreen {
	String saveName;
	Stage stage;
	Settings settings;
	
	public void init(Stage stage, GameLoop loop, Settings settings) {
		this.stage = stage;
		this.settings = settings;
		
		Pane pane = new Pane();	
		pane.setPrefSize(720, 720);
		Button b = new Button();
		b.setText("Start Game");
		b.setOnMouseClicked(e -> {
			startGame(saveName, loop);
		});
		pane.getChildren().add(b);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	
	public void startGame(String saveName, GameLoop loop) {
		Game game;
		saveName ="";
		if(saveName.equals("")) {
			game = GameLoader.newGame();
		} else {
			game = GameLoader.load(saveName);
		}
		
		game.setSettings(settings);
		
		loop.start(stage,game);
	}
}
