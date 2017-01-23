package TheGame;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.input.KeyCode;

public class Settings {
	public Map<KeyCode, KeyboardHandler.Action> getKeyBindings() {
		Map map = new HashMap<KeyCode,KeyboardHandler.Action>();
		map.put(KeyCode.W, KeyboardHandler.Action.MoveUp);
        map.put(KeyCode.UP, KeyboardHandler.Action.MoveUp);
        map.put(KeyCode.D, KeyboardHandler.Action.MoveRight);
        map.put(KeyCode.RIGHT, KeyboardHandler.Action.MoveRight);
        map.put(KeyCode.S, KeyboardHandler.Action.MoveDown);
        map.put(KeyCode.DOWN, KeyboardHandler.Action.MoveDown);
        map.put(KeyCode.E, KeyboardHandler.Action.MoveLeft);
        map.put(KeyCode.LEFT, KeyboardHandler.Action.MoveLeft);
		return map;
	}
	
	public static Settings load(String file) {
		return new Settings();
	}
}
