import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

public class ImageLoader {
	Map<String, Image> images = new HashMap<>();
	
	private static ImageLoader instance;
	
	private ImageLoader() {}
	
	public static ImageLoader getInstance() {
		if(instance == null)
			instance = new ImageLoader();
		return instance;
	}
	
	public void loadFolder(String folderName) {
		Image img;
		try{
			File f = new File("src\\images\\sprite.png");
			
			img = new Image(f.toURI().toURL().toString());
			images.put("a", img);
		} catch(Exception e) {
			System.out.println("err");
		}
	}
	
	public Image getImage(String name) {
		return images.get(name);
	}
	
	
}
