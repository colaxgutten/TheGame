import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

class DrawHelper {
	GraphicsContext gc;
	
	public DrawHelper(GraphicsContext gc) {
		
	}
	
	private void drawGame(Game game) {
/*		switch(game.getState()) {
		case State.Normal:
			drawMap(game.getMap());
			drawAnimations(game.getAnimations());
		}
	*/	
	}
	
	public void draw(Game game) {
		drawGame(game);
		drawHUD(game.getHUD());
	} 
	
	private void drawHUD(HUD hud){
		
	}
}