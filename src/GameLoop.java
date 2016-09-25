import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

class GameLoop extends AnimationTimer implements KeyListener{
	DrawHelper dh;
	Game game;
	Stage stage;
	Canvas canvas;
	/*
	public GameLoop(Stage stage, Game game) {
		Canvas canvas = new Canvas();

		stage.setScene(new Scene(new Pane(canvas)));
		
		dh = new DrawHelper(canvas.getGraphicsContext2D());
		this.game = game;
	}
	*/
	private void createCanvas() {
		canvas = new Canvas(700, 700);
		Pane pane = new Pane(canvas);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
	}
	
	public void start(Stage stage, Game game) {
		this.game = game;
		this.stage=stage;
		createCanvas();
		dh = new DrawHelper(canvas);
		
		new KeyboardHandler(canvas, game, this);
		
		
		super.start();
	}
	
	@Override
	public void handle(long arg0) {
		dh.draw(game);
	}
	
	public void stop(){
		super.stop();
		StartScreen ss = new StartScreen();
		ss.init(stage, this, game.getSettings());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		while (true){
			System.out.println("hei");
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}