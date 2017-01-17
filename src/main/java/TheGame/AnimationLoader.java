package TheGame;

import java.io.FileReader;

import org.jdom2.Document;

public class AnimationLoader {

	ClassLoader classLoader = getClass().getClassLoader();
	private String defaultParth = classLoader.getResource("animations").getFile();
	
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
