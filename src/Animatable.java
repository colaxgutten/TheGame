import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public abstract class Animatable {
	private HashMap<String, Animation> animations;
	private String currentAnimation;
	private int x;
	private int y;
	
	public String getImageString(long currentTime){
		return animations.get(currentAnimation).getFrame(currentTime);
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
		animations.get(currentAnimation).start(currentTime);
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
	
}
