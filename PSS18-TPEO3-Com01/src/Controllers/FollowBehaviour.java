package Controllers;

import GameObjects.GameObject;
import GameObjects.Vector2;
public class FollowBehaviour extends Behaviour {

    protected Vector2 u;

    public FollowBehaviour(GameObject or, GameObject de){
        m = new FollowMovement(or, de);
    }

    public Vector2 getDir(){
        updateDir();
        return direc;
    }



    private void updateDir(){


        float x = m.getX();


        float y =  m.getY();

        Vector2 vec = new Vector2(x,y);
        direc = vec;//.norma();
    }


}
