package Controllers;

public class Sinusoidal extends MovementPattern {

    public Sinusoidal() {
        ampx = 0.0000243f;
        ampy = 00010f;
    }

    @Override
    public float getX() {
        updateT();
        return t*ampx ;
    }

    @Override
    public float getY() {
        updateT();
        return (float) Math.sin(t*2)*  ampy;
    }
}
