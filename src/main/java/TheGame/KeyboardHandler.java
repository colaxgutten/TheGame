package TheGame;

import java.util.Map;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class KeyboardHandler {
	public enum Action { MoveUp, MoveLeft, MoveDown, MoveRight };
	private Map<KeyCode, Action> bindings;
	
	public KeyboardHandler(Canvas canvas, Game game, GameLoop loop) {
		bindings = game.getSettings().getKeyBindings(); 
				
		canvas.setOnKeyPressed(e -> {
			long time = System.currentTimeMillis();
			
			//game.getAnimatables().get(0).setCurrentAnimation("f", System.currentTimeMillis());
			switch(e.getCode()) {
			case A:
				game.getPlayer().walkLeft(time);
				break;
			case S:
				game.getPlayer().walkDown(time);
				break;
			case D:
				game.getPlayer().walkRight(time);
				break;
			case W:
				game.getPlayer().walkUp(time);
				break;
			default:
				break;
			}
		});
	}
	
	private Action getAction(KeyCode key) {
		return bindings.get(key);
	}
}
