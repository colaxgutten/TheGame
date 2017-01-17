package TheGame;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class TileMap {
	public static final String DEFAULT_TILE = "illuminati.jpg";
	
	private Map<Point, Tile> grid = new HashMap<>();
	private Point selected;
	private Point selectedDecTile;
	private int selectedDecIndex;

	public void setTile(Point pos, Tile tile){
		grid.put(pos, tile);
	}
	
	public Map<Point, Tile> getMap(){
		return grid;
	}

	public Tile getTile(Point pos) {
		if(!grid.containsKey(pos)) {
			return Tile.getBasicTile();
		}
		
		return grid.get(pos);
	}
	
	public int getSize(){
		return grid.size();
	}
	
	public void addDecoration(Point pos, Decoration dec) {
		if(grid.get(pos) == null) {
			grid.put(pos, Tile.getBasicTile());
		}
		grid.get(pos).getDecorations().add(dec);
	}
	
	public void printTiles(){
		System.out.println("trying to print tiles");
		System.out.println("size of tileMap is: "+grid.size());
		for (Tile t : grid.values()){
			System.out.println(t);
		}
	}
	
	
	
	
	public static TileMap loadFromFile(File file) {
		TileMap tileMap = new TileMap();
		
		if(file == null || !file.exists()) {
			return tileMap;
		}

		return tileMap;
	}
	
	public void selectTileAt(int x, int y) {
		selected = new Point(x, y);
	}
	
	public Tile getSelected() {
		return getTile(selected);
	}
	
	public void removeSelection() {
		selected = null;
	}
	
	public String decString() {
		String s = "";
		for(Map.Entry<Point, Tile> entry : grid.entrySet()) {
			s += entry.getValue().getDecorationSaveString();
		}
		return s;
	}
	
	/**
	 * Lager en tekst ut av tilemappen for � lagre slik:
	 * xpos,ypos,tileImageId,solid 
	 * med mellomrom som skilletegn mellom hver tile som skal lagres.
	 * @return save tekst.
	 */
	public String toString(){
		String save ="";
		for (Entry<Point,Tile> entry : grid.entrySet()){
			Point p = entry.getKey();
			Tile t = entry.getValue();
			save+=p.x+","+p.y+","+t.getTileImageId()+",";
			if(t.isSolid())
				save+="t";
			else
				save+="f";
			save+=",";
			save+=t.getClass().getName();
			save+=",";
			save+=t.getParamString();
			save+=" ";
		}
		return save;
	}

	public void update(long time) {
		
	}
}