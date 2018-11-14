package Controllers;

import java.util.Random;

public class PowerUpMovement extends MovementPattern {
    protected int randomSpeed;
    public PowerUpMovement(){
        Random rand = new Random();
        randomSpeed = rand.nextInt(9)+3;
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return randomSpeed;
    }
}
