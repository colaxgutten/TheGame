import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class DrawHelper {
	GraphicsContext gc;
	Stage stage;
	private int numOfXTiles = 16;
	private int numOfYTiles = 16;
	private int tileSize = 48;
	
	public DrawHelper(Stage stage) {
		Canvas canvas = new Canvas(700,700);
		gc = canvas.getGraphicsContext2D();
		Pane pane = new Pane();
		pane.getChildren().add(canvas);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
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