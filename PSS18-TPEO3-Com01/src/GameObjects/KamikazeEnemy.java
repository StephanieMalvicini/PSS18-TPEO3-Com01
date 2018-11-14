package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Controllers.*;
import Map.Map;

public class KamikazeEnemy extends Enemy {

    public KamikazeEnemy(){

        lvl = Map.getInstance().getLevel();
        health = 120 * (0.5f * lvl);
        speed = 0.1f;
        ubication = posInicial;
        dir = Vector2.ORIGIN();
        kamikazeDamage = 50 + (12 * lvl);
        sprite = SpriteDepot.KAMIKAZE1;
        c = new EnemyCollider(this, kamikazeDamage);
        score = 150 +25 * lvl;
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
