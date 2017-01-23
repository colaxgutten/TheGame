package TheGame;

import javafx.scene.input.KeyCode;

/**
 * Created by Daniel on 23.01.2017.
 */
public class Keybindings {
    private KeyCode[] walkKeyBindings;
    public Keybindings(){

    }


    /**
     * Returns a list of keybindings assigned to walk actions in following order:
     * Left,Up,Right,Down
     * @return walkbindings
     */
    public KeyCode[] getWalkKeyBindings(){
        if (walkKeyBindings==null){
            KeyCode[] walk = new KeyCode[4];
            walk[0]=KeyCode.A;
            walk[1]=KeyCode.W;
            walk[2]=KeyCode.D;
            walk[3]=KeyCode.W;
        }
        return walkKeyBindings;
    }
}
