package Controllers;

import GameObjects.Vector2;
import Map.Map;
import PowerUps.AbstractPU;

public class PowerUpMovementController extends IMovementController {

    AbstractPU controlled;

    public PowerUpMovementController(AbstractPU o, Behaviour b){
        controlled = o;
        this.b = b;
        Map.getInstance().add(this);
    }
    protected void move(Vector2 vec)
    {
        controlled.setDirec(vec);
    }

    @Override
    public void update(Map map)
    {
        if (controlled.isAlive()) {
            super.update(map);


        }
        else
            destroyMe(map);
    }
}
