import java.util.ArrayList;
import java.util.HashMap;

public class GameLoader {
	public static Game load(String saveName) {
		return null;
	} 
	
	public static Game newGame() {
		Game game = new Game();
		
		ImageLoader.getInstance().loadFolder("s");

		HashMap<String, Animation> anims = new HashMap<>();
		anims.put("f", Animation.fromString("sd"));
		
		
		Decoration dec = new Decoration(anims, 0, 0);
		ArrayList<Animatable> animatables = new ArrayList<Animatable>();
		animatables.add(dec);
		
		
		game.setAnimatables(animatables);
		
		return game;
	}
}
