package Controllers;

import GameObjects.MovingObject;
import GameObjects.Vector2;
import GameObjects.Vector2Int;
import Map.Map;

import javax.swing.*;

public  class BasicMovementController extends IMovementController { //TODO: hacer superinterfaz de controladores

    protected MovingObject controlled;


    public BasicMovementController(MovingObject o, Behaviour b){
        controlled = o;
        this.b = b;

        r = o.getSprite();
        l = o.getSprite();
        d = o.getSprite();
        u = o.getSprite();
        lu = o.getSprite();
        ru = o.getSprite();
        rd = o.getSprite();
        ld = o.getSprite();
        c = o.getSprite();


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



    private Icon getIcon(Vector2Int v){
        return m[v.getX()+1][v.getY()+1];
        //obtiene el icono asociado de la matriz en funcion del vector
    }



    protected void move(Vector2 vec)
    {
        controlled.setDirec(vec);
        controlled.setSprite(getIcon(Vector2Int.Implicit(vec.norma())));

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


}
