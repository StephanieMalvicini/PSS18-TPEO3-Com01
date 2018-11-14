package Controllers;


import GameObjects.MovingObject;
import GameObjects.Vector2;

public abstract class MovementController<E extends MovingObject>  extends IMovementController {

    protected E controlled;





    protected void move(Vector2 vec)
    {
        controlled.setDirec(vec);

    }




}
