package Controllers;

import GameObjects.Vector2;

public class PowerUpBehaviour extends Behaviour {

    public PowerUpBehaviour(){
        m = new PowerUpMovement();
    }

    @Override
    public Vector2 getDir() {
        updateDir();
        return direc;
    }

}
