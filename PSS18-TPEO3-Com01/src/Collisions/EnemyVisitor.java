package Collisions;

import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Player;
import Map.Map;

public class EnemyVisitor implements Visitor {

    float d;
    public EnemyVisitor(float dmg){
        d = dmg;
    }

    @Override
    public void visitEnemy(EnemyCollider e) {

    }

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {
        b.getO().destroyMe(Map.getInstance());


    }

    @Override
    public void visitEnemyBullet(EnemyBulletCollider b) {

    }

    @Override
    public void visitPlayer(PlayerCollider p) {
        p.getO().damage(80);

    }

    @Override
    public void visitEnemyBarricade(EnemyBarricadeCollider b) {

    }

    @Override
    public void visitBarricade(BarricadeCollider b) {

    }

    @Override
    public void visitPowerUp(PowerUpCollider b) {

    }

    @Override
    public void visitKamikazeShield(KamikazeShieldCollider b) {
        b.getO().destroySelf();

    }

    @Override
    public void visitPiercingBullet(PiercingBulletCollider b) {

    }


}
