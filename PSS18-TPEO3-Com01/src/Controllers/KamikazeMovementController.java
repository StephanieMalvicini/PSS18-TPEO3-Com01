package Controllers;

import Assets.Paths;
import GameObjects.Enemy;
import GameObjects.Ship;
import GameObjects.Vector2;
import Map.Map;

import javax.swing.*;

public class KamikazeMovementController extends IMovementController {

    protected Ship controlled;


    public KamikazeMovementController(Enemy e, FollowBehaviour be){
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

    public void update(Map map)
    {
        if (controlled.isAlive()) {
            Vector2 vec = armarVector();
            move(vec);
        }
        else
            destroyMe(map);
    }


    protected void move(Vector2 vec)
    {
        controlled.setDirec(vec);
    }




    protected Vector2 armarVector() {
        return b.getDir();
    }

    public void destroyMe(Map map) {
        map.destroy(this);
    }
}
