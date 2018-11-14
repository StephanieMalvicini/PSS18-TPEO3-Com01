package GameObjects;

import Assets.Configs;
import Assets.SpriteDepot;
import Collisions.EnemyBarricadeCollider;
import Map.Map;

import java.util.Random;

public class EnemyBarricade extends Barricade {

    public EnemyBarricade(int xBarricade, int yBarricade){

        ubication = new Vector2(xBarricade,yBarricade);
        health = 700;
        sprite = SpriteDepot.ENEMYBARRICADE;
        c = new EnemyBarricadeCollider(this);
        Map.getInstance().add(this);
    }

    @Override
    public void destroySelf() {
        destroyMe(Map.getInstance());
        sprite = null;


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

    }


}
