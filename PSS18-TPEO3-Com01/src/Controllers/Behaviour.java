package Controllers;

import GameObjects.Vector2;

public abstract class Behaviour {

    protected Vector2 direc;
    protected MovementPattern m;
    protected boolean isPaused;

    public abstract Vector2 getDir();

    protected void updateDir(){

        if(isPaused){
            direc = new Vector2(0,0);
        }
        else{
            float x = m.getX();


            float y = m.getY();

            Vector2 vec = new Vector2(x, y);
            direc = vec;
        }
    }

    public void pause() {
        isPaused = true;
    }

    public void unpause(){
        isPaused = false;
    }

    public boolean isPaused(){
        return isPaused;
    }
}
