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


    private void updateDir(){
        float x = m.getX();
                //(float) ((Math.cos(t) * ampx * Math.sqrt(2))/((Math.sin(t) * Math.sin(t)) + 1)) ;

        float y =  m.getY();
                //(float) ((Math.sin(t) * Math.cos(t) * ampx * Math.sqrt(2))/((Math.sin(t) * Math.sin(t)) + 1));
        direc = (new Vector2(x,y));
        direc = direc.prod(radioGral);
    }
}