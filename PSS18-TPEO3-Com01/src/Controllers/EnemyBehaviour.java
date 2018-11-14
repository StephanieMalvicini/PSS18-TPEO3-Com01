package Controllers;

import GameObjects.Vector2;


public class EnemyBehaviour extends Behaviour {
    private float radioGral = 0.86f;

    public EnemyBehaviour(MovementPattern mov){
        direc = Vector2.LEFT();
        m = mov;
    }

    public Vector2 getDir(){
        updateDir();
        return direc;
    }


    protected void updateDir(){
        if(!isPaused) {
            float x = m.getX();


            float y = m.getY();

            direc = (new Vector2(x, y));
            direc = direc.prod(radioGral);
        }
    }
}