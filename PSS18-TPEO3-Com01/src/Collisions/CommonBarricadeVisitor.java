package Collisions;

import Map.Map;

public class CommonBarricadeVisitor extends Visitor {


    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {
        b.getO().destroyMe(Map.getInstance());
    }

    public void visitEnemyBullet(EnemyBulletCollider b){
        b.getO().destroyMe(Map.getInstance());
    }

    @Override
    public void visitPiercingBullet(PiercingBulletCollider b) {

        b.getO().destroyMe(Map.getInstance());
    }

}
