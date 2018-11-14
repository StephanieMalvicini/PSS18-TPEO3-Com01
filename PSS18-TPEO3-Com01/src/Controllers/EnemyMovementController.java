package Controllers;

import Assets.Paths;
import Map.Map;

import javax.swing.*;

import GameObjects.MovingObject;
public class EnemyMovementController extends MovementController { //TODO: se puede mejorar usando genericidad parametrica para el tipo de controlled




    public EnemyMovementController(MovingObject e, Behaviour be){
        b = be;
        controlled = e;

        r = new ImageIcon(Paths.ENEMY1);
        l = new ImageIcon(Paths.ENEMY1);
        d = new ImageIcon(Paths.ENEMY1);
        u = new ImageIcon(Paths.ENEMY1);
        lu = new ImageIcon(Paths.ENEMY1);
        ru = new ImageIcon(Paths.ENEMY1);
        rd = new ImageIcon(Paths.ENEMY1);
        ld = new ImageIcon(Paths.ENEMY1);
        c = new ImageIcon(Paths.ENEMY1);


        m = new ImageIcon[3][3];
        m[0][0]=lu;
        m[1][0]=u;
        m[2][0]=ru;
        m[0][1]=l;
        m[1][1]=c;
        m[2][1]=r;
        m[0][2]=rd;
        m[1][2]=d;
        m[2][2]=ld;

        Map.getInstance().add(this);
    }





    @Override
    public void update(Map map)
    {
        if (controlled.isAlive()) {
            super.update(map);


        }
        else
            destroyMe(map);
    }




    public MovingObject getShip(){
        return controlled;
    }


}
