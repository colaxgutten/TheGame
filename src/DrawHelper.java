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
	
	private void drawGame(Game game) {
		for (int i =0; i<numOfXTiles;i++){
			for (int j = 0; j<numOfYTiles;j++){
				gc.fillRect(i*tileSize, j*tileSize,tileSize,tileSize);
			
			}
		}
	}
	
	public void draw(Game game) {
		drawGame(game);
		drawHUD(game.getHUD());
	} 
	
	private void drawHUD(HUD hud){
		
	}
}