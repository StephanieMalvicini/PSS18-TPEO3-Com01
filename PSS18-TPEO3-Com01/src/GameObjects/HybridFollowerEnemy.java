package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Map.Map;

public class HybridFollowerEnemy extends Enemy {

    public HybridFollowerEnemy(){

        health = 200 + 30 * lvl;
        speed = 0.1f;
        ubication = new Vector2(200,200);
        dir = Vector2.ORIGIN();
        kamikazeDamage = 40 * 10 * lvl;
        sprite = SpriteDepot.KAMIKAZEHYBRID;
        c = new EnemyCollider(this, kamikazeDamage);
        score = 150 +25 * lvl;
        lvl = Map.getInstance().getLevel();
        Map.getInstance().add(this);
    }

    public void update(Map map) {
        if (isAlive()) {
            updatePosition(map);
            super.update(map);
        } else {
            destroySelf();
            destroyMe(map);
        }
    }
}
