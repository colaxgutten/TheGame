import javafx.scene.canvas.Canvas;

public class KeyboardHandler {
	public KeyboardHandler(Canvas canvas, Game game, GameLoop loop) {
		canvas.setOnKeyPressed(e -> {
			System.out.println("SDF");
		});
	}
}
