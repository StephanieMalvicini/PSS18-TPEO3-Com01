package Collisions;

import GameObjects.PlayerBullet;

public class PlayerBulletCollider extends Collider {


    public PlayerBulletCollider(PlayerBullet o) {
        super(o);
        v = new PlayerBulletVisitor(o.getDaño());
    }



    @Override
    public void accept(Visitor v) {
        v.visitPlayerBullet(this);


    }


}
