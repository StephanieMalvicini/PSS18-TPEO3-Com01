package Controllers;


import Assets.Configs;
import GameObjects.GameObject;
import GameObjects.Vector2;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class FollowMovement extends MovementPattern {
    protected Vector2 o, d;
    protected GameObject so, sd;
    float distX = Configs.getConfigs().getCanvasWidth();
    float distY = Configs.getConfigs().getFieldHeigth();
    float x1;
    float x2;
    float y1;
    float y2;


    public FollowMovement(GameObject or, GameObject de) {
        so = or;
        sd = de;
    }
    @Override
    public float getX() {
        updateP();
        x2 = d.getX();
        x1 = o.getX();

        return min(abs(x2-x1), abs(distX - x2 + x1)) ;
    }

    private void updateP() {
        o = so.getUbication();
        d = sd.getUbication();
    }

    @Override
    public float getY() {
        updateP();
        y2 = d.getY();
        y1 = o.getY();

        return y2-y1;//return min(y2-y1, distY - y1 + y2) ;
    }



}
