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
	/*
	public GameLoop(Stage stage, Game game) {
		Canvas canvas = new Canvas();

		stage.setScene(new Scene(new Pane(canvas)));
		
		dh = new DrawHelper(canvas.getGraphicsContext2D());
		this.game = game;
	}
	*/
	public void start(Stage stage, Game game) {
		this.stage=stage;
		dh = new DrawHelper(stage);
		this.game = game;
		
		super.start();
	}
	
	@Override
	public void handle(long arg0) {
		dh.draw(game);
	}
	
	public void stop(){
		super.stop();
		StartScreen ss = new StartScreen();
		ss.init(stage, this);
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