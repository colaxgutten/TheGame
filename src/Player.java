
import java.util.HashMap;

public class Player extends Character {
	
	public Player(Game game, HashMap<String,Animation> animations, int x, int y) {
		super(game, animations, x, y);
		this.setCurrentAnimation("walkLeft", System.currentTimeMillis());
	}

}
