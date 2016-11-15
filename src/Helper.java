import java.util.HashMap;

public class Helper {
	public static HashMap<String, Animation> getSingleAnimation(String s){
		HashMap<String, Animation> map = new HashMap();
		map.put(s, Animation.fromString(s));
		return map;
	}
}
