package Controllers;

import GameObjects.Vector2;
import Map.Map;

import javax.swing.*;

public abstract class IMovementController implements IController {

    protected Icon r,l,d,u,lu,ru, rd, ld,c;
    protected Icon[][] m;
    protected Behaviour b;


    protected abstract void move(Vector2 vec);

    public void update(Map map) {
        Vector2 vec = armarVector(); // new Vector2(0,0);
        move(vec);
    }


    protected Vector2 armarVector() {
        return b.getDir();
    }

    public void destroyMe(Map map) {
        map.destroy(this);
    }


}
