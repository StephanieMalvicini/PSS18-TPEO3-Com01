package GameObjects;

import Assets.SpriteDepot;
import Collisions.PlayerBulletCollider;

public class MissilBullet extends PlayerBullet {
    public MissilBullet(float d, Vector2 ubication) {
        setUbication(ubication);
        daño = d;
        dir = new Vector2(0, -1);
        speed = 6.3f;
        sprite = SpriteDepot.LASER;
        health = 1;
        c = new PlayerBulletCollider(this);
    }
}
