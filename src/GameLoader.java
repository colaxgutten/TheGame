import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class GameLoader {
	public static Game load(String saveName) {
		return null;
	} 
	
	public static Game newGame() {
		Game game = new Game();
		ImageLoader.getInstance().loadFolder("s");

		ArrayList<Animatable> animatables = new ArrayList<Animatable>();
		MapLoader ml = new MapLoader();
		Camera camera = new Camera();
		ml.loadMap("src\\saveFile.txt");
		TileMap t = ml.getTileMap();
		game.setTiles(t);
		game.setCamera(camera);
		System.out.println(animatables.size());
		addAllTiles(t,animatables);
		game.setAnimatables(animatables);

		HashMap<String,Animation> anim = new HashMap<>();
		ArrayList<AnimationImage> imgs = new ArrayList<>();
		imgs.add(new AnimationImage("c", 1000));
		anim.put("walkLeft", new Animation(imgs));
		anim.put("lookLeft", new Animation(imgs));
		game.setPlayer(new Player(game, anim, 1, 1));
		
		return game;
	}

	private static void addAllTiles(TileMap t, ArrayList<Animatable> animatables) {
		Iterator entries = t.getMap().entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  Point key = (Point)thisEntry.getKey();
		  Tile value = (Tile)thisEntry.getValue();
		}
	}
}
