package TheGame;

import java.util.HashMap;

import javafx.geometry.Point2D;

public class Character extends Animatable {
	protected Game game;
	public enum Dir {Up, Down, Left, Right}
	
	private Dir walkDir;
	private Dir nextDir;
	private Point2D stopAt;
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
	}
	
	public void walkRight(long time) {
	}
	
	public void walkUp(long time) {
	}
	
	public void walkDown(long time) {/*
		if(this.walkDir == null) {
			this.setCurrentAnimation("walkDown", time);
			this.walkDir = Dir.Down;
		}*/
	}
	
	public Point2D getPos() {
		return truePos;
	}

	public void walk(Dir dir) {
		if(walkDir != null) {
			stopAt = truePos;
			nextDir = dir;
		} else {
			walkDir = dir;
		}
	}

	public void stop() {
		stopAt = truePos;
	}

	public void step(Dir dir, int steps) {

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

		if(stopAt != null) {
			if(truePos.getX() > Math.ceil(stopAt.getX())) {
				setPos((int)Math.ceil(stopAt.getX()), getY());
				truePos = new Point2D(getX(), getY());
				walkDir = nextDir;
				nextDir = null;
				stopAt = null;
				this.setCurrentAnimation("lookRight", time);
			}

			else if(truePos.getX() < Math.floor(stopAt.getX())) {
				setPos((int)Math.floor(stopAt.getX()), getY());
				truePos = new Point2D(getX(), getY());
				walkDir = nextDir;
				nextDir = null;
				stopAt = null;
				this.setCurrentAnimation("lookLeft", time);
			}

			else if(truePos.getY() > Math.ceil(stopAt.getY())) {
				setPos(getX(), (int)Math.ceil(stopAt.getY()));
				truePos = new Point2D(getX(), getY());
				walkDir = nextDir;
				nextDir = null;
				stopAt = null;
				this.setCurrentAnimation("lookDown", time);
			}

			else if(truePos.getY() < Math.floor(stopAt.getY())) {
				setPos(getX(), (int)Math.floor(stopAt.getY()));
				truePos = new Point2D(getX(), getY());
				walkDir = nextDir;
				nextDir = null;
				stopAt = null;
				this.setCurrentAnimation("lookUp", time);
			}
		}

		lastUpdate = time;
	}
}
