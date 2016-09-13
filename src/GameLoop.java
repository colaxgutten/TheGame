import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class GameLoop {
	DrawHelper dh;
	Game game;
	
	public GameLoop(Stage stage, Game game) {
		Canvas canvas = new Canvas();

		stage.setScene(new Scene(new Pane(canvas)));
		
		dh = new DrawHelper(canvas.getGraphicsContext2D());
		this.game = game;
	}
	
	public void start() {
		game.update();
		DrawHelper.draw(game);
	}
}