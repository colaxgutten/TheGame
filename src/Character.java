import java.util.HashMap;

import javafx.geometry.Point2D;

public class Character extends Animatable {
	protected Game game;
	private enum Dir {Up, Down, Left, Right};
	
	private Dir walkDir;
	private double speed;
	private long lastUpdate;
	private Point2D truePos;
	
	public Character(Game game, HashMap<String,Animation> animations, int x, int y) {
		super(animations, x, y);
		this.game = game;
		this.truePos = new Point2D(x, y);
		this.speed = 1.0/100;
	}
	
	public void walkLeft(long time) {
		this.setCurrentAnimation("walkLeft", time);
		this.walkDir = Dir.Left;
	}
	
	public Point2D getPos() {
		return truePos;
	}
	
	public void update(long time) {
		if(walkDir == null) {
			lastUpdate = time;
			return;
		}
		
		double dist;
		if(lastUpdate == 0)
			dist = 0;
		else
			dist = speed * (time - lastUpdate);

		switch(walkDir) {
		case Left:
			truePos = truePos.subtract(dist, 0);
			break;
		case Right:
			truePos = truePos.add(dist, 0);
			break;
		case Up:
			truePos = truePos.subtract(0, dist);
			break;
		case Down:
			truePos = truePos.add(0, dist);
			break;
		}

		if(truePos.getX() - getX() >= 1) {
			setPos(getX() + 1, getY());
			truePos = new Point2D(getX(), getY());
			walkDir = null;
			this.setCurrentAnimation("lookRight", time);
		}
		if(truePos.getX() - getX() <= -1) {
			setPos(getX() - 1, getY());
			truePos = new Point2D(getX(), getY());
			walkDir = null;
			this.setCurrentAnimation("lookLeft", time);
		}
		if(truePos.getY() - getY() >= 1) {
			setPos(getX(), getY() + 1);
			truePos = new Point2D(getX(), getY());
			walkDir = null;
			this.setCurrentAnimation("lookDown", time);
		}
		if(truePos.getY() - getY() <= -1) {
			setPos(getX(), getY() - 1);
			truePos = new Point2D(getX(), getY());
			walkDir = null;
			this.setCurrentAnimation("lookUp", time);
		}
		
		lastUpdate = time;
	}
}
