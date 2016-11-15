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
		ml.loadMap("src\\saveFile.txt");
		TileMap t = ml.getTileMap();
		game.setTiles(t);
		System.out.println(animatables.size());
		addAllTiles(t,animatables);
		game.setAnimatables(animatables);
		
		return game;
	}

	private static void addAllTiles(TileMap t, ArrayList<Animatable> animatables) {
		Iterator entries = t.getMap().entrySet().iterator();
		while (entries.hasNext()) {
		  Entry thisEntry = (Entry) entries.next();
		  Point key = (Point)thisEntry.getKey();
		  Tile value = (Tile)thisEntry.getValue();
		 animatables.add(value);
		}
		t.startAnimations(System.currentTimeMillis());
		
	}
	
}
