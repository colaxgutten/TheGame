import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class GameLoop extends AnimationTimer {
	DrawHelper dh;
	Game game;
	Stage stage;
	/*
	public GameLoop(Stage stage, Game game) {
		Canvas canvas = new Canvas();

		stage.setScene(new Scene(new Pane(canvas)));
		
		dh = new DrawHelper(canvas.getGraphicsContext2D());
		this.game = game;
	}
	*/
	public void start(Stage stage, Game game) {
		super.start();
		this.stage=stage;
		this.game = game;
	}
	
	@Override
	public void handle(long arg0) {
		
		
	}
}