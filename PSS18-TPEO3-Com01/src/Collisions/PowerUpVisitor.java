package Collisions;

public class PowerUpVisitor implements Visitor {
    @Override
    public void visitEnemy(EnemyCollider e) {

    }

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {

    }

    @Override
    public void visitEnemyBullet(EnemyBulletCollider b) {

    }

    @Override
    public void visitPlayer(PlayerCollider p) {

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

    }

    @Override
    public void visitPiercingBullet(PiercingBulletCollider b) {

    }
}
