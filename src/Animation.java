import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Animation {
	private List<AnimationImage> frames;
	private long startTime;
	private long runTime;
	
	public Animation(List<AnimationImage> frames) {
		this.frames = frames;
		
		for(AnimationImage frame : frames) {
			runTime += frame.delay;
		}
	}
	
	public void start(long time) {
		startTime = time;
	}
	
	public String getFrame(long time) {
		if(startTime == 0)
			return null;
		
		long curTime = (time - startTime) % runTime;
		
		int totalTime = 0;
		
		for(int i = 0; i < frames.size(); i++) {
			totalTime += frames.get(i).delay;
			if(totalTime > curTime) {
				System.out.println(i);
				System.out.println(curTime);
				return frames.get(i).name;
				
			}
		}
		
		return null;
	}
	
	public static Animation fromString(String str) {
		List<AnimationImage> frames = new ArrayList<>();
		frames.add(new AnimationImage("a", 1000));
		frames.add(new AnimationImage("b",3000));
		frames.add(new AnimationImage("c",300));
		
		return new Animation(frames);
	}
}
