package Collisions;

import Map.Map;

public class EnemyVisitor extends Visitor {

    protected float d;

    public EnemyVisitor(float dmg){
        d = dmg;
    }



    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {
        b.getO().destroyMe(Map.getInstance());


    }



    @Override
    public void visitPlayer(PlayerCollider p) {
        p.getO().damage(80);

    }



    @Override
    public void visitKamikazeShield(KamikazeShieldCollider b) {
        b.getO().destroySelf();

    }

    @Override
    public void visitPiercingBullet(PiercingBulletCollider b) {

    }


}
