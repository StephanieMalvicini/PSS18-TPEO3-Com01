package Controllers;

public abstract class MovementPattern {

    protected float ampy;
    protected float ampx;
    protected float t;



    public abstract float getX();
    public abstract float getY();


    protected void updateT(){t = System.nanoTime()/1_000_000_000f;}
}
