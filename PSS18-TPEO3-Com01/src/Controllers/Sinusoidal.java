package Controllers;

public class Sinusoidal extends MovementPattern {

    public Sinusoidal() {
        ampx = 0.000543f;
        ampy = 0010f;
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
