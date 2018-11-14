package Controllers;

import GameObjects.EnemyFighter;
import Map.Map;

public class FighterFireController extends IFireController{

   protected EnemyFighter controlled;


    public FighterFireController(EnemyFighter f){
        controlled = f;
    }

    @Override
    public void destroyMe(Map map) {
        map.destroy(this);
    }

    public void Fire() {
        controlled.fire();
    }




    protected void checkShoot()
    {

        if(fire())
        {
            Fire();
        }

    }



    @Override
    public void update(Map map)
    {
        if (controlled.isAlive()) {
            checkShoot();


        }
        else
            destroyMe(map);
    }

    public boolean fire() {
        double r = Math.random();
        if (r<0.28 )
            return true;
        else
            return false;
    }

}
