import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
		loop.start(stage,game);
	}
}
