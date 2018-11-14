package GameObjects;

import Assets.SpriteDepot;
import Collisions.EnemyCollider;
import Controllers.*;
import Map.Map;

public class KamicazeEnemy extends Enemy {

    public KamicazeEnemy(int d){

        health = 200;
        speed = 0.1f;
        ubication = new Vector2(200,200);
        dir = Vector2.ORIGIN();
        kamikazeDamage = 150;
        sprite = SpriteDepot.ENEMY1;
        c = new EnemyCollider(this, kamikazeDamage);
        score = 150;
        lvl = d;
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
