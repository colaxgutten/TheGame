package TheGame;

import java.util.List;

public class Game {
	private Settings settings;
	private List<Animatable> animatables;
	private TileMap tiles;
	private Camera camera;
	private Player player;
	
	public void setCamera(Camera camera){
		this.camera=camera;
	}
	
	public Camera getCamera(){
		return camera;
	}
	
	public TileMap getTiles(){
		return tiles;
	}

	public void update(long time) {
		tiles.update(time);
		player.update(time);
		camera.update(player);
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

	public void setTiles(TileMap t) {
		this.tiles=t;
		
	}

}
