import java.awt.Point;
import java.util.Map.Entry;
import java.util.Random;


import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class DrawHelper {
	GraphicsContext gc;
	Stage stage;
	Random random = new Random();
	private int numOfXTiles = 16;
	private int numOfYTiles = 16;
	private int tileSize = 48;
	
	public DrawHelper(Canvas canvas) {
		gc = canvas.getGraphicsContext2D();
		canvas.setFocusTraversable(true);
	}
	
	private void drawGame(Game game,long time) {
		for (Entry e : game.getTiles().getMap().entrySet()){
			Tile t = (Tile)e.getValue();
			Point p =(Point) e.getKey();
			Image im = ImageLoader.getInstance().getImage(t.getTileImageId());
			gc.drawImage(im, p.getX()*tileSize, p.getY()*tileSize,tileSize,tileSize);
		}
//		for (Animatable a : game.getAnimatables()){
//			int x = a.getX()*tileSize;
//			int y = a.getY()*tileSize;
//			gc.drawImage(ImageLoader.getInstance().getImage(a.getImageString(time)),x,y,tileSize,tileSize);
//		}
		/*for (int i =0; i<numOfXTiles;i++){
			for (int j = 0; j<numOfYTiles;j++){
				gc.fillRect(i*tileSize, j*tileSize,tileSize,tileSize);
			
			}
		}*/
	}
	
	public void draw(Game game,long time) {
		gc.clearRect(0, 0, 720, 720);
		drawGame(game,time);
		drawHUD(game.getHUD());
	} 
	
	private void drawHUD(HUD hud){
		
	}
}