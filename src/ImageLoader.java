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
		Image img2;
		Image img3;
		try{
			File f = new File("src\\images\\illuminati.jpg");
			File g = new File("src\\images\\sprite.png");
			File d = new File("src\\images\\stone_stonebrick.png");
			img = new Image(f.toURI().toURL().toString());
			img2 = new Image(g.toURI().toURL().toString());
			img3 = new Image(d.toURI().toURL().toString());
			images.put("a", img);
			images.put("b", img2);
			images.put("c", img3);
		} catch(Exception e) {
			System.out.println("err");
		}
	}
	
	public Image getImage(String name) {
		return images.get(name);
	}
	
	
}
