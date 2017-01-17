package TheGame;

public class Camera {
	private double x=8.0;
	private double y=8.0;
	private double zoom = 1;
	private final int tilesWidth = 17;
	private final int tilesHeigth = 17;
	
	/**
	 * Camera - x,y is at the center of the screen
	 */
	public Camera(){}
	
	public int getWidth(){
		return tilesWidth;
	}
	
	public int getHeigth(){
		return tilesHeigth;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double x){
		this.x=x;
	}
	
	public void setY(double y){
		this.y=y;
	}
	
	public void setZoom(double zoom){
		this.zoom=zoom;
	}
	
	public double getZoom(){
		return zoom;
	}
	
	public int getTilesOff(){
		return tilesWidth/2-1;
	}

	public void update(Player player) {
		this.x=player.getPos().getX();
		this.y=player.getPos().getY();
		
	}
	
}
