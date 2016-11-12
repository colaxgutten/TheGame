import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MapLoader {
	private TileMap tileMap;
	public void loadMap (String fileName){
		System.out.println("Denne blir kallt");
		File file = new File(fileName);
		
		try(FileReader fr = new FileReader(file)) {
			BufferedReader br = new BufferedReader(fr);
			
			tileMap = new TileMap();

			String tileLine = br.readLine();
			
			if(tileLine == null) {
				System.out.println("no tile line");
				return;
			}
			
			for(String tileString : tileLine.split(" ")) {
				String[] tileArray = tileString.split(",");
				int posX = Integer.valueOf(tileArray[0]);
				int posY = Integer.valueOf(tileArray[1]);
				String tileImageId = tileArray[2];
				String type = tileArray[4];
				String[] params = tileArray.length > 5 ? tileArray[5].split(";") : new String[0];
				
				boolean solid = false;
				if (tileArray[3].equals("t"))
					solid=true;
				
				Tile tile = Tile.getTile(type, params, tileImageId, solid);
				
				tileMap.setTile(new Point(posX, posY), tile);
			}
			
			String decLine = br.readLine();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public TileMap getTileMap(){
		return tileMap;
	}
}
