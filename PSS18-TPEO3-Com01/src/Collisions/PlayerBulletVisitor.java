package Collisions;

public class PlayerBulletVisitor implements Visitor {

    float d;

    public PlayerBulletVisitor(float d){
        this.d = d;
    }

    @Override
    public void visitEnemy(EnemyCollider e) {
            e.getO().damage(d);

    }

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {

    }

    @Override
    public void visitEnemyBullet(EnemyBulletCollider b) {

    }

    @Override
    public void visitEnemyBarricade(EnemyBarricadeCollider b) {
        b.getO().damage(d);
    }

    @Override
    public void visitBarricade(BarricadeCollider b) {

    }

    @Override
    public void visitPowerUp(PowerUpCollider b) {

    }

    @Override
    public void visitKamikazeShield(KamikazeShieldCollider b) {

    }

    @Override
    public void visitPiercingBullet(PiercingBulletCollider b) {

    }


    @Override
    public void visitPlayer(PlayerCollider p) {

    }
}
