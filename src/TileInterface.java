public interface TileInterface {
	
	public void onWalkOver(Player player);
	
	public void onAction(Player player);
	
	public void onTrigger(String event, Tile caller);
}
