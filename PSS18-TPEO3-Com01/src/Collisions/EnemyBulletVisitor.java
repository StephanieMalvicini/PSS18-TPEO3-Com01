package Collisions;

public class EnemyBulletVisitor implements Visitor {
    float d;

    public EnemyBulletVisitor(float dmg){
        d = dmg;
    }

    @Override
    public void visitEnemy(EnemyCollider e) {

        //System.out.println("choco");
    }

    @Override
    public void visitPlayerBullet(PlayerBulletCollider b) {

    }

    @Override
    public void visitEnemyBullet(EnemyBulletCollider b) {

    }



    @Override
    public void visitPlayer(PlayerCollider p) {
        p.getO().damage(d);

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
