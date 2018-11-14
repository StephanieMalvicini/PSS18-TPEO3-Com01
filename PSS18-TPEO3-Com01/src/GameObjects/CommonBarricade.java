package GameObjects;

import Assets.SpriteDepot;
import Collisions.CommonBarricadeCollider;
import Map.Map;

public class CommonBarricade extends Barricade{

    public CommonBarricade(int xBarricade, int yBarricade){

        ubication = new Vector2(xBarricade,yBarricade);
        health = 2000;
        sprite = SpriteDepot.ENEMYBARRICADE;
        c = new CommonBarricadeCollider(this);
        Map.getInstance().add(this);
    }

    @Override
    public void destroySelf() {
        destroyMe(Map.getInstance());
    }

    @Override
    public void update(Map map) {
        c.update();
        if(!isAlive()){
            destroySelf();
        }

    }

    @Override
    public void destroyMe(Map map) {
        map.destroy(this);
        sprite = null;
    }




}
