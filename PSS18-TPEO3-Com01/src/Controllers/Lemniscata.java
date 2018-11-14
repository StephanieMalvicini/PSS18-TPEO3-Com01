package Controllers;

public class Lemniscata extends MovementPattern {


    public Lemniscata() {
        ampx = 24.13f;
        ampy = 15.07f;
    }

    @Override
    public float getX() {
        updateT();

        return (float) ((ampx * Math.sqrt(2)*(-Math.sin(t)*((Math.sin(t) * Math.sin(t)) + 1) - Math.sin(2*t) * Math.cos(t)))/
                (((Math.sin(t) * Math.sin(t)) + 1) * ((Math.sin(t) * Math.sin(t)) + 1)));
    }

    @Override
    public float getY() {
        updateT();

        return (float) ( (ampy * (3 * Math.cos(2 * t) - 1) ) /
                ((( Math.sqrt(2) * (( Math.sin(t) * Math.sin(t)) + 1 )*((Math.sin(t) * Math.sin(t) ) + 1 ))))) ;
    }

}
