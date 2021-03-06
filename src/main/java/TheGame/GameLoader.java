package TheGame;

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

		GameLoader gl = new GameLoader();
		ClassLoader classLoader = gl.getClass().getClassLoader();
		String map = classLoader.getResource("saves/saveFile.txt").getFile();

		System.out.println("Loading new game");
		Game game = new Game();
		ImageLoader.getInstance().loadFolder(classLoader.getResource("images").getFile());

		ArrayList<Animatable> animatables = new ArrayList<Animatable>();
		MapLoader ml = new MapLoader();
		Camera camera = new Camera();
		ml.loadMap(map);
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
		anim.put("walkRight", new Animation(imgs));
		anim.put("walkUp", new Animation(imgs));
		anim.put("walkDown", new Animation(imgs));
		anim.put("lookLeft", new Animation(imgs));
		anim.put("lookRight", new Animation(imgs));
		anim.put("lookUp", new Animation(imgs));
		anim.put("lookDown", new Animation(imgs));
		game.setPlayer(new Player(game, anim, 1, 1));
		
		return game;
	}

	private static void addAllTiles(TileMap t, ArrayList<Animatable> animatables) {
		Iterator<Entry<Point,Tile>> entries = t.getMap().entrySet().iterator();
		while (entries.hasNext()) {
		  Entry<Point,Tile> thisEntry = (Entry<Point,Tile>) entries.next();
		  Point key = (Point)thisEntry.getKey();
		  Tile value = (Tile)thisEntry.getValue();
		}
	}
}
