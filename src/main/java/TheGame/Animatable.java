package TheGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public abstract class Animatable {
	private HashMap<String, Animation> animations;
	private String currentAnimation;
	private int x;
	private int y;
	
	public String getImageString(long currentTime){
		if(currentAnimation == null){
			return "";
		}
		else if (animations!=null){
		return animations.get(currentAnimation).getFrame(currentTime);
		}
		System.out.println("HashMap<String, Animation> is null");
		return "";
	}
	
	public Animatable(){
		
	}
	
	public Animatable(HashMap<String,Animation> animations){
		this.animations=animations;
	}
	
	public Animatable(HashMap<String,Animation> animations, int x, int y){
		this.animations=animations;
		this.x=x;
		this.y=y;
	}
	
	public void addAnimation(Animation a,String name){
		animations.put(name,a);
	}
	
	public void setCurrentAnimation (String a, long currentTime){
		this.currentAnimation=a;
		System.out.println(a);
		if (animations!=null){
		if (!animations.containsKey(a) && a!= null){
			AnimationImage ai = new AnimationImage(a,1000);
			ArrayList<AnimationImage> list = new ArrayList<>();
			list.add(ai);
			Animation an = new Animation(list);
		}
		animations.get(currentAnimation).start(currentTime);
		}
	}
	
	public void removeAnimation(String name){
		if (animations.get(name)!=null)
			animations.remove(name);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
