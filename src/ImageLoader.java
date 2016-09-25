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
		Image img = new Image("C:\\Users\\Eirik\\git\\TheGame\\src\\images\\sprite.png");
		images.put("a", img);
	}
	
	public Image getImage(String name) {
		return images.get(name);
	}
	
	
}
