import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class MapLoader {
	private TileMap tileMap;
	private ArrayList<DecorationOld> listOfOld = null;
	public void loadMap (String fileName){
		System.out.println("Denne blir kallt");
		File file = new File(fileName);
		listOfOld = new ArrayList();
		
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
				tile.setX(posX);
				tile.setY(posY);
				tileMap.setTile(new Point(posX, posY), tile);
			}
			
			String decLine = br.readLine();
			if(decLine == null) {
				System.out.println("no decoration line");
				return;
			}
			
			for(String decString : decLine.split(" ")) {
				String[] decArray = decString.split(",");
				int posX = Integer.valueOf(decArray[0]);
				int posY = Integer.valueOf(decArray[1]);
				double xAdjust = Double.valueOf(decArray[2]);
				double yAdjust = Double.valueOf(decArray[3]);
				
				DecorationOld dec = new DecorationOld(posX, posY, xAdjust, yAdjust, decArray[4]);
				
				listOfOld.add(dec);
			}
			oldToNewDecorations();
			//test();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public TileMap getTileMap(){
		return tileMap;
	}
	//OOPPPSSS!!! Animation blir laget her for testing, burde bli opprettet fra XML og vere tilgjengelig gjennom en hashmap
	public void oldToNewDecorations(){
		long time = System.currentTimeMillis();
		for (DecorationOld d : listOfOld){
			HashMap<String, Animation> anim = new HashMap();
			ArrayList<AnimationImage> aiList = new ArrayList();
			int x = d.getxPos();
			int y = d.getyPos();
			AnimationImage ai = new AnimationImage(d.getImageName(),1000);
			aiList.add(ai);
			Animation a = new Animation(aiList);
			anim.put(d.getImageName(), a);
			a.start(time);
			Decoration dec = new Decoration(anim, x, y, (int)d.getxAdjust(), (int)d.getyAdjust());
			dec.setCurrentAnimation(d.getImageName(), System.currentTimeMillis());
			tileMap.getTile(new  Point(x,y)).getDecorations().add(dec);
		}
	}
	
	public void test(){
		for (int i = 0; i<16;i++){
			for (int j = 0; j<16;j++){
				Tile t = tileMap.getTile(new Point(i,j));
				System.out.println(t.getTileImageId());
				System.out.println(t.getX());
				System.out.println(t.getY());
				for (Decoration d : t.getDecorations()){
					System.out.println(d.getX());
					System.out.println(d.getY());
					System.out.println(d.getImageString(System.currentTimeMillis()));
				}
			}
		}
	}
}
