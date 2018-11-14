package Collisions;

public class PlayerVisitor implements Visitor {
    @Override
    public void visitEnemy(EnemyCollider e) {
        e.getO().damage(1000);

    }

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {

    }

    @Override
    public void visitEnemyBullet(EnemyBulletCollider b) {
        b.getO().destroySelf();

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
        System.out.println("activo");
        b.trigger();
        b.getO().destroySelf(); //destroy it
    }

    @Override
    public void visitKamikazeShield(KamikazeShieldCollider b) {

    }

    @Override
    public void visitPiercingBullet(PiercingBulletCollider b) {

    }
}
