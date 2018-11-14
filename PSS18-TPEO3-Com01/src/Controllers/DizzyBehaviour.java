package Controllers;

import GameObjects.Vector2;

public class DizzyBehaviour extends Behaviour {

    public DizzyBehaviour(){
        m = new DizzyMovement();
    }


    @Override
    public Vector2 getDir() {
        updateDir();
        return direc;
    }
}
