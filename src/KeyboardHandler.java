import java.util.HashMap;
import java.util.Map;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class KeyboardHandler {
	public enum Action { MoveUp, MoveLeft, MoveDown, MoveRight };
	private Map<KeyCode, Action> bindings;
	
	public KeyboardHandler(Canvas canvas, Game game, GameLoop loop) {
		bindings = game.getSettings().getKeyBindings(); 
				
		canvas.setOnKeyPressed(e -> {
			
		});
	}
	
	private Action getAction(KeyCode key) {
		return bindings.get(key);
	}
}
