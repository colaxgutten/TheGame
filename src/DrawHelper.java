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
		Camera cam = game.getCamera();
		for (Entry e : game.getTiles().getMap().entrySet()){
			Tile t = (Tile)e.getValue();
			Point p =(Point) e.getKey();
			if (isWithinScreen(p,cam)){
			Image im = ImageLoader.getInstance().getImage(t.getTileImageId());
			gc.drawImage(im, ((p.getX()+cam.getTilesOff())-cam.getX())*tileSize, ((p.getY()+cam.getTilesOff())-cam.getY())*tileSize,tileSize,tileSize);
			}
		}
		for (Entry e : game.getTiles().getMap().entrySet()){
			Tile t = (Tile)e.getValue();
			if (isWithinScreen((Point)e.getKey(),cam)){
			if (t.getDecorations()!=null){
				Point p =(Point) e.getKey();
				for (Decoration d : t.getDecorations()){
					Image im = ImageLoader.getInstance().getImage(d.getImageString(time));
					double drawPosX = ((p.getX()+cam.getTilesOff())-cam.getX() + d.getxElevate()) * tileSize - im.getWidth()/2*cam.getZoom() + (tileSize/2);
					double drawPosY = ((p.getY()+cam.getTilesOff())-cam.getY() + d.getyElevate()) * tileSize - im.getHeight()*cam.getZoom() + tileSize;
					
					gc.drawImage(im, drawPosX, drawPosY);
				}
			}
			}
		}
		
		Player f = (Player)game.getPlayer();
		gc.drawImage(ImageLoader.getInstance().getImage(f.getImageString(time)), (f.getPos().getX()+cam.getTilesOff()-cam.getX())*tileSize, (f.getPos().getY()+cam.getTilesOff()-cam.getY())*tileSize);

		/*for (int i =0; i<numOfXTiles;i++){
			for (int j = 0; j<numOfYTiles;j++){
				gc.fillRect(i*tileSize, j*tileSize,tileSize,tileSize);
			
			}
		}*/
	}
	
	private boolean isWithinScreen(Point p, Camera cam) {
		double x= p.getX()*tileSize*cam.getZoom();
		double y = p.getY()*tileSize*cam.getZoom();
		double centerHeigthDifferance = cam.getHeigth()*(tileSize*cam.getZoom())/2;
		double centerWidthDifferance = cam.getWidth()*(tileSize*cam.getZoom())/2;
		double xLow = (cam.getX()*cam.getZoom()*tileSize)-centerWidthDifferance;
		double yLow=(cam.getY()*cam.getZoom()*tileSize)-centerHeigthDifferance;
		double xHigh = (cam.getX()*cam.getZoom()*tileSize)+centerWidthDifferance;
		double yHigh = (cam.getY()*cam.getZoom()*tileSize)+centerHeigthDifferance;
		if (x<xLow || y < yLow || x > xHigh || y > yHigh)
			return false;
		return true;
	}

	public void draw(Game game,long time) {
		gc.clearRect(0, 0, 720, 720);
		drawGame(game,time);
		drawHUD(game.getHUD());
	} 
	
	private void drawHUD(HUD hud){
		
	}
}