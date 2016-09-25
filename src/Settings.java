import java.util.Map;

import javafx.scene.input.KeyCode;

public class Settings {
	public Map<KeyCode, KeyboardHandler.Action> getKeyBindings() {
		return null;
	}
	
	public static Settings load(String file) {
		return new Settings();
	}
}
