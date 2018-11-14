package Controllers;

import GameObjects.MovingObject;
import GameObjects.Vector2;

public abstract class MovementController extends IMovementController {

    protected MovingObject controlled;





    protected void move(Vector2 vec)
    {
        controlled.setDirec(vec);
        //controlled.setSprite(getIcon(Vector2Int.Implicit(vec.norma())));

    }


}
