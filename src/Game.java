import java.util.List;

import javafx.scene.image.Image;

public class Game {
	private Settings settings;
	private List<Animatable> animatables;
	private Player player;
	
	public String getTiles(){
		return "C:\\Users\\Daniel\\workspace\\TileMapEditor\\images\\tileImages\\runite.jpg";
	}

	public void update(long time) {
		player.update(time);
	}

	public HUD getHUD() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setAnimatables(List<Animatable> anims) {
		this.animatables = anims;
	}
	
	public List<Animatable> getAnimatables(){
		return this.animatables;
	}

	public Settings getSettings() {
		return this.settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}

}
