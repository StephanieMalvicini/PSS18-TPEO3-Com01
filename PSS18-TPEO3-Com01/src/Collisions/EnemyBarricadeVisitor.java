package Collisions;

import Map.Map;

public class EnemyBarricadeVisitor extends Visitor {

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {
        b.getO().destroyMe(Map.getInstance());
    }

    @Override
    public void visitPiercingBullet(PiercingBulletCollider b) {

            b.getO().destroyMe(Map.getInstance());
    }
}
