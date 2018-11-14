package Controllers;

import GUI.MyListener;
import GameObjects.Player;
import Map.Map;


public class PlayerFireController implements IController {

    public PlayerFireController(){
        Map.getInstance().add(this);

    }

    public void Fire() {
        Player.getInstance().fire();
    }



    @Override
    public void update(Map map) {
        if(MyListener.getInstance().fire())
            Fire();

    }

    @Override
    public void destroyMe(Map map) {
        map.remove(this);

    }
}
