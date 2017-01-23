package TheGame;

import java.util.ArrayList;
import java.util.Map;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;

public class KeyboardHandler {
	public enum Action { MoveUp, MoveLeft, MoveDown, MoveRight };
	private Map<KeyCode, Action> bindings;
	private ArrayList<KeyCode> pressed;
	private Keybindings keys;
	
	public KeyboardHandler(Canvas canvas, Game game, GameLoop loop) {
	    keys = new Keybindings();
		bindings = game.getSettings().getKeyBindings();
		pressed = new ArrayList<KeyCode>();

		canvas.setOnKeyPressed(e -> {
			long time = System.currentTimeMillis();
			Action newlyPressed = getAction(e.getCode());
			if (!pressed.contains(e.getCode()))
			pressed.add(e.getCode());

			//game.getAnimatables().get(0).setCurrentAnimation("f", System.currentTimeMillis());
            if (newlyPressed!=null)
			switch(newlyPressed) {
                case MoveLeft:
				game.getPlayer().walk(Character.Dir.Left,time);
				break;
                case MoveDown:
                game.getPlayer().walk(Character.Dir.Down,time);
				break;
                case MoveRight:
				game.getPlayer().walk(Character.Dir.Right,time);
				break;
                case MoveUp:
                game.getPlayer().walk(Character.Dir.Up,time);
				break;
			default:
				break;
			}
		});

		canvas.setOnKeyReleased(e -> {
		    long time = System.currentTimeMillis();
		    if (pressed.contains(e.getCode())){
		        pressed.remove(e.getCode());
            }
            System.out.println(pressed.size());
		    boolean walk = false;
            for (int i = 0; i< pressed.size();i++){
		        KeyCode c = pressed.get(pressed.size()-i-1);
		        if (c!=null){
		            Action a = getAction(c);
		            if (a!=null){
		                if (a == Action.MoveUp) {
                            game.getPlayer().walk(Character.Dir.Up, time);
                            walk=true;
                            break;
                        }
		                else if (a == Action.MoveRight){
		                    game.getPlayer().walk(Character.Dir.Right,time);
		                    walk=true;
		                    break;
                        } else if (a == Action.MoveDown){
		                    game.getPlayer().walk(Character.Dir.Down,time);
		                    walk=true;
		                    break;
                        } else if (a == Action.MoveLeft){
                            game.getPlayer().walk(Character.Dir.Left,time);
                            walk=true;
                            break;
                        } else {
                            game.getPlayer().stop();
                            break;
                        }
                    }
                }
            }
            if (!walk) {
                System.out.println("Spiller burde stoppe");
                game.getPlayer().stop();
            }
        });
	}

	
	private Action getAction(KeyCode key) {
		return bindings.get(key);
	}
}
