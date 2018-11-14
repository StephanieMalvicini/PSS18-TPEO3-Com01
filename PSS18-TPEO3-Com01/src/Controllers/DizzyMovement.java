package Controllers;

public class DizzyMovement extends MovementPattern {

    public DizzyMovement(){
    }

    @Override
    public float getX() {
        updateT();
        return t;
    }

    @Override
    public float getY() {
        updateT();
        return (float) Math.cos(t)*t;
    }
}
