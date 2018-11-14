package Controllers;

import GameObjects.Vector2;

public class FollowFormation  extends MovementPattern{

    protected Vector2 origen, destination;

    @Override
    public float getX() {
        return destination.getX() - origen.getX();
    }


    @Override
    public float getY() {
        return destination.getY() - origen.getY();
    }



    public void setOrigen(Vector2 origen) {
        this.origen = origen;
    }

    public void setDestination(Vector2 destination) {
        this.destination = destination;
    }
}
