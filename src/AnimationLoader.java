import java.io.FileReader;

import org.jdom2.Document;

public class AnimationLoader {
	
	private String defaultParth = "src\\";
	
	private AnimationLoader() {}
	
	private static AnimationLoader instance;
	
	public static AnimationLoader getInstance() {
		if(instance == null)
			instance = new AnimationLoader();
		return instance;
	}
	
	public Animation getAnimation(String name){
		
		return null;
	}
	
	private String getXMLFromPath(String path){
		FileReader fr = null;
		String xml = "";
		Document d = new Document();
		try {
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
