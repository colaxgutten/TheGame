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

		HashMap<String,Animation> anim = new HashMap<>();
		ArrayList<AnimationImage> imgs = new ArrayList<>();
		imgs.add(new AnimationImage("c", 1000));
		anim.put("walkLeft", new Animation(imgs));
		anim.put("lookLeft", new Animation(imgs));
		game.setPlayer(new Player(game, anim, 1, 1));
		
		return game;
	}
}
