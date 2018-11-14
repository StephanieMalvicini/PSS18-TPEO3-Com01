package GameObjects;

import Assets.SpriteDepot;
import Collisions.PiercingBulletCollider;
import Collisions.PlayerBulletCollider;

public class PiercingBullet extends Bullet {

    public PiercingBullet(float damage, Vector2 u) {
        setUbication(ubication);
        daño = damage;
        dir = new Vector2(0, -1);
        speed = 6.3f;
        sprite = SpriteDepot.LASER;
        health = 1;
        ubication = u;
        c = new PiercingBulletCollider(this);
    }
}
