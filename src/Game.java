import javafx.scene.image.Image;

public class Game {
	private Settings settings;
	
	public String getTiles(){
		return "C:\\Users\\Daniel\\workspace\\TileMapEditor\\images\\tileImages\\runite.jpg";
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public HUD getHUD() {
		// TODO Auto-generated method stub
		return null;
	}

	public Settings getSettings() {
		return this.settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

}
