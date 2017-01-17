package TheGame;

import java.util.HashMap;

public class Decoration extends Animatable {
	private int xElevate = 0;
	private int yElevate = 0;
	
	public Decoration(HashMap<String, Animation> anims, int x, int y, int xElevate, int yElevate) {
		super(anims, x, y);
		this.xElevate=xElevate;
		this.yElevate =yElevate;
	}

	public int getxElevate() {
		return xElevate;
	}

	public int getyElevate() {
		return yElevate;
	}

	public void setxElevate(int xElevate) {
		this.xElevate = xElevate;
	}

	public void setyElevate(int yElevate) {
		this.yElevate = yElevate;
	}
	
}
