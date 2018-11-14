package GameObjects;

import Assets.SpriteDepot;
import Collisions.PlayerBulletCollider;
import Map.Map;

public class MissilBullet extends PlayerBullet {
    public MissilBullet(float d, Vector2 ubication) {
        setUbication(ubication);
        daño = d;
        dir = new Vector2(0, -1);
        speed = 6.3f;
        sprite = SpriteDepot.MISSILE;
        health = 1;
        c = new PlayerBulletCollider(this);
        Map.getInstance().add(this);
    }

    public void update(Map map) {
        super.update(map);
        updatePosition(map);
    }
}
