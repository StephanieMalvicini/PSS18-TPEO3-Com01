package Controllers;

import GameObjects.GameObject;
import GameObjects.Vector2;
public class FollowBehaviour extends Behaviour {


    public FollowBehaviour(GameObject or, GameObject de){
        m = new FollowMovement(or, de);
    }

    public Vector2 getDir(){
        updateDir();
        return direc;
    }






}
